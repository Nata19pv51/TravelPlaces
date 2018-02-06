package org.mycompany.myname.model.dao.implement;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplaNote {
    private long time;
    private int userId;
    private String text;
    private double coord;

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

    public double getCoord() {
        return coord;
    }

    public void setCoord(double coord) {
        this.coord = coord;
    }

    static public List<JDBCDisplaNote> getDisplayNotesByUserID(int userId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";

        List<JDBCDisplaNote> notes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(Query.findAllNotesByUserId(userId))) {

            JDBCDisplaNote note;
            while (resultSet.next()) {
                note = new JDBCDisplaNote();
                note.setUserId(userId);
                note.setText(resultSet.getString("text"));
                note.setCoord(resultSet.getDouble("coordinate"));
                note.setTime(resultSet.getLong("dateCreation"));
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return notes;
    }

    public static void main(String[] args){
        List<JDBCDisplaNote> nodes =  JDBCDisplaNote.getDisplayNotesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(nodes);
        System.out.println(jsonString);
    }
}
