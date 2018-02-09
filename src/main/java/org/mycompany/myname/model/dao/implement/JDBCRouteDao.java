package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.IRouteDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRouteDao implements IRouteDao {
    private Connection connection;
//    public JDBCRouteDao(String table, Connection connection) {
//        super(table,connection);
//    }

    public JDBCRouteDao(Connection connection) {
        this.connection = connection;
    }

    protected Route extractFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(Route.ID_ROUTE);
        String name = resultSet.getString(Route.NAME);
        Date dateCreation = resultSet.getDate(Route.DATE_CREATION);
        //int idUser = resultSet.getInt(TableParameters.User.ID_USER);
        return new Route.RouteBuilder()
                .setIdRoute(id)
                .setName(name)
                .setDateCreation(dateCreation)
                .build();
    }

    @Override
    public void create(Route route) throws Exception {
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO " + Route.ROUTE_TABLE + " (" + Route.NAME + ", " +
                        Route.DATE_CREATION + ", " +Route.ID_USER +
                        ") VALUES (?, ?, ?)")){
            preparedStatement.setString(1, route.getName());
            preparedStatement.setObject(2, route.getDateCreation());
            preparedStatement.setInt(3, route.getUser().getIdUser());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Route findById(int id) {
        return null;
    }

    public Route findRouteById(int id) {
        return findById(id);
    }


    @Override
    public List<Route> findAll(int id) {
        List<Route> routeList = new ArrayList<>();
        try(Statement ps = connection.createStatement()){
            ResultSet resultSet = ps.executeQuery(Query.findAllRoutesByUser(id));
            while (resultSet.next()){
                Route route = extractFromResultSet(resultSet);
                routeList.add(route);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return routeList;
    }

    @Override
    public void update(Route route) {
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE " + Route.ROUTE_TABLE + " SET name = ? WHERE " + Route.ID_ROUTE + " = ?")){
            preparedStatement.setString(1, route.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM " + Route.ROUTE_TABLE + " WHERE " + Route.ID_ROUTE + " = ?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
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
