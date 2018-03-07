package org.mycompany.myname.model.dao.implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDisplayPhoto {
    final public static String PHOTO_TABLE = "notePhoto";
    final public static String ID_NOTE = "id_note";
    final public static String URL_PHOTO = "url_photo";

    private int idNote;
    private String url;

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

}
