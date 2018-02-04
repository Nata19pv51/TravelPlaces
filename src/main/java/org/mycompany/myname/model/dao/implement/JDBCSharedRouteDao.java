package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.ISharedRouteDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.SharedRoute;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCSharedRouteDao implements ISharedRouteDao {
    private Connection connection;
//    public JDBCSharedRouteDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCSharedRouteDao(Connection connection) {
        this.connection = connection;
    }

    protected SharedRoute extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void create(SharedRoute entity) throws Exception {

    }

    @Override
    public SharedRoute findById(int id) {
        return null;
    }

    @Override
    public List<SharedRoute> findAll(int id) {
        List<SharedRoute> list = new ArrayList<>();
        try(Statement ps = connection.createStatement()){
            ResultSet resultSet = ps.executeQuery(Query.findAllSharedNotesByUser(id));
            while (resultSet.next()){
                SharedRoute sharedRoute = extractFromResultSet(resultSet);
                list.add(sharedRoute);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(SharedRoute entity) throws Exception {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
