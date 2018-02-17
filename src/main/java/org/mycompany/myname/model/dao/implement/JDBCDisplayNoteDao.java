package org.mycompany.myname.model.dao.implement;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.IDisplayNoteDao;
import org.mycompany.myname.model.entity.DisplayNote;
import org.mycompany.myname.model.entity.Text;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayNoteDao implements IDisplayNoteDao {

    private Connection connection;
//    public JDBCDisplayNoteDao(Connection connection) {
//        this.connection = connection;
//    }

    @Override
    public void create(DisplayNote note) throws Exception {
        String query =  "UPDATE " + Text.TEXT_TABLE + " SET " + Text.TEXT + " = ?" +
                " WHERE " + Text.ID_NOTE + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, note.getText());
            preparedStatement.setInt(2, note.getNoteId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DisplayNote findById(int id) {
//        String URL = "jdbc:mysql://localhost/Travel";
//        String USER  = "root";
//        try (Statement ps = connection.createStatement()) {
//            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_NOTE);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                DisplayNote note = extractFromResultSet(resultSet);
//                return note;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
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
    public void update(DisplayNote note) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";

        String query =  "UPDATE " + Text.TEXT_TABLE + " SET " + Text.TEXT + " = ?" +
                " WHERE " + Text.ID_NOTE + " = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, note.getText());
            preparedStatement.setInt(2, note.getNoteId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    List<JDBCDisplayNote> notes = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(URL, USER, "");
//    Statement ps = connection.createStatement();
//    ResultSet resultSet = ps.executeQuery(Query.findAllNotesByUserId(userId))) {
//
//        JDBCDisplayNote note;
//        while (resultSet.next()) {
//            note = new JDBCDisplayNote();
//            note.setUserId(userId);
//            note.setNoteId(resultSet.getInt("id_note"));
//            note.setText(resultSet.getString("text"));
//            note.setCoordination(resultSet.getDouble("coordinate"));
//            note.setTime(resultSet.getLong("dateCreation"));
//            notes.add(note);
//        }
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
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

//        String query = "SELECT " + DisplayNote.NOTE_TABLE + "." +
//                DisplayNote.ID_NOTE + ", " + DisplayNote.DATE_CREATION + ", " + DisplayNote.CORDINATE + ", " +
//                DisplayNote.TEXT + " FROM " + DisplayNote.NOTE_TABLE + " JOIN " + DisplayNote.COORDINATE_TABLE +
//                " ON " + DisplayNote.NOTE_TABLE + "." + DisplayNote.ID_NOTE + " = " + DisplayNote.COORDINATE_TABLE + "." + DisplayNote.ID_NOTE +
//                " JOIN " + DisplayNote.TEXT_TABLE + " ON " + DisplayNote.NOTE_TABLE + "." + DisplayNote.ID_NOTE + " = " + DisplayNote.TEXT_TABLE + "." + DisplayNote.ID_NOTE +
//                " WHERE " + DisplayNote.NOTE_TABLE + "." + DisplayNote.ID_USER + " = ?";

        String query = "SELECT note.id_note, note.id_user, note.dateCreation, coordinate.coordinate, textnode.text" +
                " FROM note JOIN coordinate ON note.id_note=coordinate.id_note " +
                " JOIN textnode ON note.id_note=textnode.id_note" +
                " WHERE note.id_user = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, "")) {
             //ResultSet resultSet = ps.executeQuery(FIND_ALL_NOTES_BY_USER);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DisplayNote note = extractFromResultSet(resultSet);
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }
//try (Connection connection = DriverManager.getConnection(URL, USER, "");
//    Statement ps = connection.createStatement();
//    ResultSet resultSet = ps.executeQuery(Query.findAllNotesByUserId(userId))) {
//
//        JDBCDisplayNote note;
//        while (resultSet.next()) {
//            note = new JDBCDisplayNote();
//            note.setUserId(userId);
//            note.setText(resultSet.getString("text"));
//            note.setCoordination(resultSet.getDouble("coordinate"));
//            note.setTime(resultSet.getLong("dateCreation"));
//            notes.add(note);
//        }
//    }
    static DisplayNote extractFromResultSet(ResultSet rs)throws SQLException {
        DisplayNote note = new DisplayNote();
        note.setNoteId(rs.getInt(DisplayNote.ID_NOTE));
        note.setUserId(rs.getInt(DisplayNote.ID_USER));
        note.setCoordination(rs.getDouble(DisplayNote.CORDINATE));
        note.setText(rs.getString(DisplayNote.TEXT));

        return note;
    }


    public static void main(String[] args){
        IDisplayNoteDao dao = new JDBCDisplayNoteDao();
        List<DisplayNote> notes = dao.findAllNotesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(notes);
        System.out.println(jsonString);
    }
}
