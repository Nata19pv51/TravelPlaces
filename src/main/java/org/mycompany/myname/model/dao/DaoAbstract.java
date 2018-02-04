package org.mycompany.myname.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DaoAbstract<T> implements IGenericDao<T>{
    private String table;
    public Connection connection;

    public DaoAbstract(String table, Connection connection) {
        this.table = table;
        this.connection = connection;
    }

    protected abstract T extractFromResultSet(ResultSet resultSet) throws SQLException;

    protected T findOne(String query) {
        try (PreparedStatement ps = connection.prepareStatement(query);) {
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return extractFromResultSet(resultSet);
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected List<T> findAll(String query) {
        List<T> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                resultList.add(extractFromResultSet(resultSet));
            }
            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T findById(int id) {
        String query = Query.findObjectById(table, id);
        return findOne(query);
    }

    @Override
    public List<T> findAll(int id) {
        String query = Query.findAll(table);
        return findAll(query);
    }

    @Override
    public void update(T entity) throws Exception {

    }

    @Override
    public void delete(int id) {
        String query = Query.deleteById(table, id);
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
