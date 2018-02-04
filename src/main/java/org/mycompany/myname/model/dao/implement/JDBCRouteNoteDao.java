package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.IRouteNoteDao;
import org.mycompany.myname.model.entity.RouteNote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCRouteNoteDao implements IRouteNoteDao{
    private Connection connection;

//    public JDBCRouteNoteDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCRouteNoteDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(RouteNote entity) {

    }

    protected RouteNote extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public RouteNote findById(int id) {
        return null;
    }

    @Override
    public List<RouteNote> findAll(int id) {
        return null;
    }

    @Override
    public void update(RouteNote entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
