package org.mycompany.myname.model.dao.implement;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayNote {
    final public static String NOTE_TABLE = "note";
    final public static String TEXT_TABLE = "textnode";
    final public static String COORDINATE_TABLE = "coordinate";
    final public static String ID_NOTE = "id_note";
    final public static String COORDINATE_LAT = "Lat";
    final public static String COORDINATE_LNG = "Lng";
    final public static String DATE_CREATION = "dateCreation";
    final public static String ID_USER = "id_user";
    final public static String TEXT = "text";
    final public static String PHOTO_TABLE = "notePhoto";
    final public static String URL_PHOTO = "url_photo";

    private long time;
    private int userId;
    private String text;
    private double lat;
    private double lng;
    private int noteId;
    private int idNote;
    private String url;
    private int routID;

    public int getRoutID() {
        return routID;
    }

    public void setRoutID(int routID) {
        this.routID = routID;
    }
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMaxID() {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "SELECT MAX(id_note) FROM note";
        int maxID;
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {
            if (resultSet.next()) {
                maxID = resultSet.getInt("MAX(id_note)");
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
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createCoordinate(int id, double lat, double lng) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "INSERT INTO coordinate (coordinate.id_note, coordinate.Lat, coordinate.Lng) VALUES (" + id + ", " + lat + ", " + lng + ")";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createRouteNote(int idRoute, int idNote) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "INSERT INTO routeNote (id_route, id_note) VALUES (" + idRoute + ", " + idNote + ")";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void savePhoto(int id_note, String url) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "INSERT INTO " + PHOTO_TABLE + " (" + ID_NOTE + ", " + URL_PHOTO + ") VALUES (\"" +
                id_note + "\", '" + url + "')";
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // public List<>

    static public List<JDBCDisplayNote> getDisplayNotesByUserID(int userId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";

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
                note.setLat(resultSet.getDouble("Lat"));
                note.setLng(resultSet.getDouble("Lng"));
                note.setTime(resultSet.getLong("dateCreation"));
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notes;
    }

    static public List<JDBCDisplayNote> getDisplayNotesByRouteID(int routeId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        String query = "SELECT note.id_note, note.dateCreation, coordinate.Lat, coordinate.Lng, textnode.text " +
                "FROM note " +
                "JOIN coordinate ON note.id_note = coordinate.id_note " +
                "JOIN textnode ON note.id_note = textnode.id_note " +
                "JOIN routeNote ON note.id_note = routeNote.id_note " +
                "WHERE routeNote.id_route =" + routeId;
//                "SELECT note.id_note, note.dateCreation, coordinate.coordinate, textnode.text " +
//                "FROM note " +
//                "JOIN coordinate ON note.id_note = coordinate.id_note " +
//                "JOIN textnode ON note.id_note = textnode.id_note " +
//                "JOIN routeNote ON note.id_note = routeNote.id_note " +
//                "WHERE routeNote.id_note = " + routeId +
//                " ORDER BY note.dateCreation DESC";
        List<JDBCDisplayNote> notes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)
        ) {
            JDBCDisplayNote note;
            while (resultSet.next()) {
                note = new JDBCDisplayNote();
                note.setNoteId(resultSet.getInt("id_note"));
                note.setText(resultSet.getString("text"));
                note.setLat(resultSet.getDouble("Lat"));
                note.setLng(resultSet.getDouble("Lng"));
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
        String USER = "root";

        String query = "UPDATE textnode SET text = ? WHERE id_note = ?";
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
        String USER = "root";
        String query = "SELECT note.id_note, note.dateCreation, textnode.text, coordinate.Lat, coordinate.Lng FROM note JOIN textnode " +
                "ON note.id_note=textnode.id_note" +
                " JOIN coordinate ON note.id_note=coordinate.id_note" +
                " WHERE note.id_note=" + noteId;
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {
            JDBCDisplayNote note = new JDBCDisplayNote();
            if (resultSet.next()) {
                note.setNoteId(resultSet.getInt("id_note"));
                note.setTime(resultSet.getLong("dateCreation"));
                note.setText(resultSet.getString("text"));
                note.setLat(resultSet.getDouble("Lat"));
                note.setLng(resultSet.getDouble("Lng"));
                return note;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        List<JDBCDisplayNote> nodes = JDBCDisplayNote.getDisplayNotesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(nodes);
        System.out.println(jsonString);
    }
}
