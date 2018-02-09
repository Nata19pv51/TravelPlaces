package org.mycompany.myname.model.dao;

import org.mycompany.myname.constants.TableParameters;

public class Query {
    public static String findAll(String table){
        return "SELECT * FROM " + table;
    }

    public static String findAllRoutesByUser(int id){
        return "SELECT " + TableParameters.Route.NAME + ", " +
                TableParameters.Route.DATE_CREATION + " FROM " + TablesName.ROUTE +
                " WHERE " + TableParameters.Route.ID_USER + " = " + id;
    }

    public static String findAllSharedNotesByUser(int id){
         return "SELECT " + TableParameters.Note.ID_NOTE + ", " +
                    TableParameters.Note.DATE_CREATION + ", " +
                    TableParameters.Coordinate.CORDINATE + ", " +
                    TableParameters.Text.TEXT + " FROM " + TablesName.SHARED_NOTE +
                    " JOIN " + TablesName.NOTE + " ON " +
                    TableParameters.SharedNote.ID_NOTE + " = " + TableParameters.Note.ID_NOTE +
                    " JOIN " + TablesName.COORDINATE + " ON " +
                    TableParameters.Note.ID_NOTE + " = " + TableParameters.Coordinate.ID_NOTE +
                    " JOIN " + TablesName.TEXT + " ON " +
                    TableParameters.Note.ID_NOTE + " = " + TableParameters.Text.ID_NOTE +
                    "WHERE " + TableParameters.SharedNote.ID_USER + " = " + id;
    }

    public static String findAllSharedRoutesByUser(int id){
        return "SELECT " + TableParameters.Route.ID_ROUTE + ", " +
                TableParameters.Route.DATE_CREATION + ", " +
                TableParameters.Route.NAME + " FROM " + TablesName.SHARED_ROUTE +
                " JOIN " + TablesName.ROUTE + " ON " +
                TableParameters.SharedRoute.ID_ROUTE + " = " + TableParameters.Route.ID_ROUTE +
                "WHERE " + TableParameters.SharedNote.ID_USER + " = " + id;
    }

    public static String findAllByIdNote(int id){
        return "SELECT " + TableParameters.Photo.URL_PHOTO + " FROM " +
                TablesName.PHOTO + " WHERE " + TableParameters.Photo.ID_NOTE + " = " + id;
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
        return "SELECT * FROM " + TablesName.USER + " WHERE login = \"" + login
                + "\" AND password = \"" + password + "\";";

    }
}
