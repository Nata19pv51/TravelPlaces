package org.mycompany.myname.model.dao.implement;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.ICoordinateDao;
import org.mycompany.myname.model.dao.INoteDao;
import org.mycompany.myname.model.dao.ITextDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.Coordinate;
import org.mycompany.myname.model.entity.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayNote{
    private long time;
    private int userId;
    private String text;
    private double coordination;
    private int noteId;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getCoordination() {
        return coordination;
    }

    public void setCoordination(double coordination) {
        this.coordination = coordination;
    }

    static public List<JDBCDisplayNote> getDisplayNotesByUserID(int userId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";

        List<JDBCDisplayNote> notes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(Query.findAllNotesByUserId(userId))) {

            JDBCDisplayNote note;
            while (resultSet.next()) {
                note = new JDBCDisplayNote();
                note.setUserId(userId);
                note.setNoteId(resultSet.getInt("id_note"));
                note.setText(resultSet.getString("text"));
                note.setCoordination(resultSet.getDouble("coordinate"));
                note.setTime(resultSet.getLong("dateCreation"));
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return notes;
    }

    public void update(JDBCDisplayNote note) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";

        String query =  "UPDATE textnode SET text = ? WHERE id_note = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, note.getText());
            preparedStatement.setInt(2, note.getNoteId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public JDBCDisplayNote getNoteByID(int noteId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        String query = "SELECT note.id_note, note.dateCreation, textnode.text FROM note JOIN textnode " +
                "ON note.id_note=textnode.id_note" +
                " WHERE note.id_note=" + noteId;
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             //PreparedStatement ps = connection.prepareStatement(query);
             ResultSet resultSet = ps.executeQuery(query)){
             //ResultSet resultSet = ps.executeQuery()) {

            JDBCDisplayNote note = new JDBCDisplayNote();
            if (resultSet.next()) {
                note.setNoteId(resultSet.getInt("id_note"));
                note.setTime(resultSet.getLong("dateCreation"));
                note.setText(resultSet.getString("text"));
//                note.setCoordination(resultSet.getDouble("coordinate"));
                //notes.add(note);
                return note;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args){
        List<JDBCDisplayNote> nodes =  JDBCDisplayNote.getDisplayNotesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(nodes);
        System.out.println(jsonString);
    }
}
