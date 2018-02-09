package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.*;

public class Query {
    public static String findAll(String table){
        return "SELECT * FROM " + table;
    }

    public static String findAllRoutesByUser(int id){
        return "SELECT " + Route.NAME + ", " +
                Route.DATE_CREATION + " FROM " + Route.ROUTE_TABLE +
                " WHERE " + Route.ID_USER + " = " + id;
    }

    public static String findAllSharedNotesByUser(int id){
         return "SELECT " + Note.ID_NOTE + ", " +
                    Note.DATE_CREATION + ", " +
                    Coordinate.CORDINATE + ", " +
                    Text.TEXT + " FROM " + SharedNote.SHARED_NOTE_TABLE +
                    " JOIN " + Note.NOTE_TABLE + " ON " +
                    SharedNote.ID_NOTE + " = " + Note.ID_NOTE +
                    " JOIN " + Coordinate.COORDINATE_TABLE + " ON " +
                    Note.ID_NOTE + " = " + Coordinate.ID_NOTE +
                    " JOIN " + Text.TEXT_TABLE + " ON " +
                    Note.ID_NOTE + " = " + Text.ID_NOTE +
                    "WHERE " + SharedNote.ID_USER + " = " + id;
    }

    public static String findAllSharedRoutesByUser(int id){
        return "SELECT " + Route.ID_ROUTE + ", " +
                Route.DATE_CREATION + ", " +
                Route.NAME + " FROM " + SharedRoute.SHARED_ROUTE_TABLE +
                " JOIN " + Route.ROUTE_TABLE + " ON " +
                SharedRoute.ID_ROUTE + " = " + Route.ID_ROUTE +
                "WHERE " + SharedNote.ID_USER + " = " + id;
    }

    public static String findAllByIdNote(int id){
        return "SELECT " + NotePhoto.URL_PHOTO + " FROM " +
                NotePhoto.PHOTO_TABLE + " WHERE " + NotePhoto.ID_NOTE + " = " + id;
    }

    public static String findAllNotesByUserId(int id){
//        return "SELECT " + TableParameters.Note.ID_NOTE + ", " +
//                TableParameters.Note.DATE_CREATION + ", " +
//                TableParameters.Coordinate.CORDINATE + ", " +
//                TableParameters.Text.TEXT + " FROM " + TablesName.NOTE +
//                " JOIN " + TablesName.COORDINATE + " ON " +
//                TableParameters.Note.ID_NOTE + " = " + TableParameters.Coordinate.ID_NOTE +
//                " JOIN " + TablesName.TEXT + " ON " +
//                TableParameters.Note.ID_NOTE + " = " + TableParameters.Text.ID_NOTE +
//                "WHERE " + TableParameters.Note.ID_USER + " = " + id;
        return "SELECT note.id_note, note.dateCreation, coordinate.coordinate, textnode.text " +
                "FROM note JOIN coordinate ON note.id_note = coordinate.id_note " +
                "JOIN textnode ON note.id_note = textnode.id_note WHERE note.id_user = " + id;
    }

    public static String findObjectById(String table, int id){
        return "SELECT * FROM " + table + " WHERE id = " + id;
    }
    public static String deleteById(String table, int id){
        return "DELETE FROM " + table + " WHERE id = " + id;
    }

    public static String deleteByParameter(String table, String parameter,
                                             String value){
        return "DELETE FROM " + table + " WHERE "
                + parameter + " = \"" + value + "\";";
    }

    public static String findAllByParameter(String table, String parameter, String value){
        return "SELECT * FROM " + table + " WHERE " + parameter + " = \"" + value + "\";";
    }

    public String findUserByParameters(String login, String password){
        return "SELECT * FROM " + User.USER_TABLE + " WHERE login = \"" + login
                + "\" AND password = \"" + password + "\";";

    }
}
