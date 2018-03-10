package org.mycompany.myname.model.dao.implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//    public void savePhoto(int id_note, String url) {
//        String URL = "jdbc:mysql://localhost/Travel";
//        String USER = "root";
//        String query = "INSERT INTO " + PHOTO_TABLE + " (" + ID_NOTE + ", " + URL_PHOTO + ") VALUES (\"" +
//                id_note + "\", '" + url + "')";
//        try (Connection connection = DriverManager.getConnection(URL, USER, "");
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    static public List<JDBCDisplayPhoto> findPhotos(int idNote){
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        List<JDBCDisplayPhoto> photoList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, USER, "");
            Statement state = connection.createStatement();
            ResultSet resultSet = state.executeQuery(
                    "SELECT " + URL_PHOTO +
                         " FROM " + PHOTO_TABLE +
                         " WHERE " + ID_NOTE + " = " + idNote))
        {
            JDBCDisplayPhoto photo;
            while (resultSet.next()) {
                photo = new JDBCDisplayPhoto();
               // photo.setIdNote(idNote);
                photo.setUrl(resultSet.getString(URL_PHOTO));
                photoList.add(photo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return photoList;
    }

    static public List<JDBCDisplayPhoto> findAllPhotosByUser(int idUser){
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        List<JDBCDisplayPhoto> photoList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, USER, "");
            Statement state = connection.createStatement();
            ResultSet resultSet = state.executeQuery(
                    "SELECT url_photo FROM notePhoto JOIN note ON" +
                            " notePhoto.id_note = note.id_note" +
                            " WHERE note.id_user = " + idUser))
        {
            JDBCDisplayPhoto photo;
            while (resultSet.next()) {
                photo = new JDBCDisplayPhoto();
                photo.setUrl(resultSet.getString(URL_PHOTO));
                photoList.add(photo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return photoList;
    }

    static public List<JDBCDisplayPhoto> findPhotosByRoute(int idRoute){
        String URL = "jdbc:mysql://localhost/Travel";
        String USER = "root";
        List<JDBCDisplayPhoto> photoList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(URL, USER, "");
            Statement state = connection.createStatement();
            ResultSet resultSet = state.executeQuery(
                    //TO DO
                    "SELECT " + URL_PHOTO +
                            " FROM " + PHOTO_TABLE +
                            " WHERE " + ID_NOTE + " = " + idRoute))
        {
            JDBCDisplayPhoto photo;
            while (resultSet.next()) {
                photo = new JDBCDisplayPhoto();
                // photo.setIdNote(idNote);
                photo.setUrl(resultSet.getString(URL_PHOTO));
                photoList.add(photo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return photoList;
    }
}
