package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.*;

import static org.mycompany.myname.model.entity.SharedNote.SHARED_NOTE_TABLE;

public interface ISharedNoteDao extends IGenericDao<SharedNote>{
    public static final String FIND_ALL = "SELECT * FROM " + SharedNote.SHARED_NOTE_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + SharedNote.SHARED_NOTE_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + SharedNote.SHARED_NOTE_TABLE + " WHERE id = ?";

    public static final String FIND_ALL_SHARED_NOTES_BY_USER = "SELECT " + Note.ID_NOTE + ", " +
            Note.DATE_CREATION + ", " + Coordinate.CORDINATE + ", " + Text.TEXT +
            " FROM " + SharedNote.SHARED_NOTE_TABLE + " JOIN " + Note.NOTE_TABLE + " ON " +
            SharedNote.ID_NOTE + " = " + Note.ID_NOTE +
            " JOIN " + Coordinate.COORDINATE_TABLE + " ON " +
            Note.ID_NOTE + " = " + Coordinate.ID_NOTE +
            " JOIN " + Text.TEXT_TABLE + " ON " +
            Note.ID_NOTE + " = " + Text.ID_NOTE +
            "WHERE " + SharedNote.ID_USER + " = ?";

}
