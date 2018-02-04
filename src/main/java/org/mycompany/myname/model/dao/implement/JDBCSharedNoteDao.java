package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.ISharedNoteDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.SharedNote;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCSharedNoteDao implements ISharedNoteDao {
    private Connection connection;
//    public JDBCSharedNoteDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCSharedNoteDao(Connection connection) {
        this.connection = connection;
    }

    protected SharedNote extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public void create(SharedNote entity) throws Exception {

    }

    @Override
    public SharedNote findById(int id) {
        return null;
    }

    @Override
    public List<SharedNote> findAll(int id) {
        List<SharedNote> list = new ArrayList<>();
        try(Statement ps = connection.createStatement()){
            ResultSet resultSet = ps.executeQuery(Query.findAllSharedNotesByUser(id));
            while (resultSet.next()){
                SharedNote sharedNote = extractFromResultSet(resultSet);
                list.add(sharedNote);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(SharedNote entity) throws Exception {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
