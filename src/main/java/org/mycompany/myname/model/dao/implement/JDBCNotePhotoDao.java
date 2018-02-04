package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.constants.TableParameters;
import org.mycompany.myname.constants.TablesName;
import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.INotePhotoDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.Note;
import org.mycompany.myname.model.entity.NotePhoto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCNotePhotoDao implements INotePhotoDao {

    private Connection connection;
//    public JDBCNotePhotoDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCNotePhotoDao(Connection connection) {
        this.connection = connection;
    }

    protected NotePhoto extractFromResultSet(ResultSet resultSet) throws SQLException {
        String url = resultSet.getString(TableParameters.Photo.URL_PHOTO);
        return new NotePhoto.NotePhotoBuilder()
                .setUrl(url)
                .build();
    }

    @Override
    public void create(NotePhoto notePhoto)throws Exception {
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO " + TablesName.PHOTO + "(" + TableParameters.Photo.ID_NOTE + ", " +
                        TableParameters.Photo.URL_PHOTO + ") VALUES (?, ?)")){
            preparedStatement.setObject(1, notePhoto.getNote());
            preparedStatement.setString(2, notePhoto.getUrl());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public NotePhoto findById(int id) {
        return null;
    }

    @Override
    public List<NotePhoto> findAll(int id) {
        List<NotePhoto> list = new ArrayList<>();
        try(Statement ps = connection.createStatement()){
            ResultSet resultSet = ps.executeQuery(Query.findAllByIdNote(id));
            while (resultSet.next()){
                NotePhoto photo = extractFromResultSet(resultSet);
                list.add(photo);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(NotePhoto entity) throws Exception {

    }

    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM " + TablesName.PHOTO + " WHERE " + TableParameters.Photo.ID_NOTE + " = ?")){
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
