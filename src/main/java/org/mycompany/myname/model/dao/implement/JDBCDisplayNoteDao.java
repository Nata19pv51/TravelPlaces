package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.IDisplayNoteDao;
import org.mycompany.myname.model.entity.DisplayNote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayNoteDao implements IDisplayNoteDao {

    private Connection connection;
//    public JDBCDisplayNoteDao(Connection connection) {
//        this.connection = connection;
//    }

    @Override
    public void create(DisplayNote entity) throws Exception {

    }

    @Override
    public DisplayNote findById(int id) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        try (Statement ps = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_NOTE);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DisplayNote note = extractFromResultSet(resultSet);
                return note;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<DisplayNote> findAll(int id) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        List<DisplayNote> notes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(FIND_BY_ID_NOTE)) {

            while (resultSet.next()) {
                DisplayNote note = extractFromResultSet(resultSet);
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    @Override
    public void update(DisplayNote entity) throws Exception {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DisplayNote> findAllNotesByUserID(int id) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        List<DisplayNote> notes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(FIND_ALL_NOTES_BY_USER)) {

            while (resultSet.next()) {
                DisplayNote note = extractFromResultSet(resultSet);
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    static DisplayNote extractFromResultSet(ResultSet rs)throws SQLException {
        DisplayNote note = new DisplayNote();
        note.setNoteId(rs.getInt(DisplayNote.ID_NOTE));
        note.setUserId(rs.getInt(DisplayNote.ID_USER));
        note.setCoordination(rs.getDouble(DisplayNote.CORDINATE));
        note.setText(rs.getString(DisplayNote.TEXT));
        return note;
    }
}
