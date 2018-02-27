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
    final public static String NOTE_TABLE = "note";
    final public static String TEXT_TABLE = "textnode";
    final public static String COORDINATE_TABLE = "coordinate";
    final public static String ID_NOTE = "id_note";
    final public static String COORDINATE = "coordinate";
    final public static String DATE_CREATION = "dateCreation";
    final public static String ID_USER = "id_user";
    final public static String TEXT = "text";

    private long time;
    private int userId;
    private String text;
    private double coordination;
    private int noteId;
    //private int maxID;

//    public int getMaxID() {
//        return maxID;
//    }
//
//    public void setMaxID(int maxID) {
//        this.maxID = maxID;
//    }

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

    public int getMaxID(){
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        String query = "SELECT MAX(id_note) FROM note";
        int maxID;
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)){
            //JDBCDisplayNote note = new JDBCDisplayNote();
            if(resultSet.next()){
                maxID = resultSet.getInt("MAX(id_note)");
                // note.setMaxID(resultSet.getInt("id_note"));
                return maxID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void createNote(int userId) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        long curTime = System.currentTimeMillis();
        String query = "INSERT INTO " + NOTE_TABLE + " (" + DATE_CREATION + ", " + ID_USER + ") VALUES (" +
                curTime + ", " + userId + ")";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createText(int id, String text) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "INSERT INTO textnode (textnode.id_note, textnode.text) VALUES (" + id + ", '" + text + "')";
//        String query = "INSERT INTO " + TEXT_TABLE + " (" + ID_NOTE + ", " + TEXT + ") VALUES (" + id + ", \"" + text + "\"); " +
//                        "INSERT INTO " + COORDINATE_TABLE + " (" + ID_NOTE + ", " + COORDINATE + ") VALUES (" + id + ", " + location + ")";

//        INSERT INTO `textnode`(`id_note`, `text`) VALUES (5, "Hello")
//        INSERT INTO `coordinate`(`id_note`, `coordinate`) VALUES (5, 23.34545)
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCoordinate(int id, double location) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "INSERT INTO coordinate (coordinate.id_note, coordinate.coordinate) VALUES (" + id + ", " + location + ")";

//        String query = "INSERT INTO " + TEXT_TABLE + " (" + ID_NOTE + ", " + TEXT + ") VALUES (" + id + ", \"" + text + "\"); " +
//                        "INSERT INTO " + COORDINATE_TABLE + " (" + ID_NOTE + ", " + COORDINATE + ") VALUES (" + id + ", " + location + ")";

//        INSERT INTO `textnode`(`id_note`, `text`) VALUES (5, "Hello")
//        INSERT INTO `coordinate`(`id_note`, `coordinate`) VALUES (5, 23.34545)
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    INSERT INTO note ('dateCreation', 'id_user') VALUES (23423432535, 2);
//    INSERT INTO textnode ('text') VALUES ("Hello");
//    INSERT INTO coordinate ('coordinate') VALUES (35.242434);

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
        String query = "SELECT note.id_note, note.dateCreation, textnode.text, coordinate.coordinate FROM note JOIN textnode " +
                "ON note.id_note=textnode.id_note" +
                " JOIN coordinate ON note.id_note=coordinate.id_note" +
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
                note.setCoordination(resultSet.getDouble("coordinate"));
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
