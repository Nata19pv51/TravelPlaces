package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.Coordinate;
import org.mycompany.myname.model.entity.Note;
import org.mycompany.myname.model.entity.Text;
import org.mycompany.myname.model.entity.User;

public interface INoteDao extends IGenericDao<Note> {
    public static final String FIND_ALL = "SELECT * FROM " + Note.NOTE_TABLE;

    public static final String FIND_BY_ID = "SELECT * FROM " + Note.NOTE_TABLE + " WHERE id = ?";

    public static final String DELETE_BY_ID = "DELETE FROM " + Note.NOTE_TABLE + " WHERE id = ?";

    public static final String  CREATE = "INSERT INTO " + Note.NOTE_TABLE +
            " (" + Note.ID_NOTE + ", " + Note.DATE_CREATION + ", " + Note.ID_USER + ") VALUES (?, ?, ?)";

    public static final String UPDATE = "UPDATE " + Note.NOTE_TABLE +
            " SET " + Note.ID_NOTE + " = ?, " + Note.DATE_CREATION + " = ? WHERE " +Note.ID_NOTE + " = ?";

    public static final String FIND_ALL_NOTES_BY_USER = "SELECT " +
            Note.ID_NOTE + ", " + Note.DATE_CREATION + ", " + Coordinate.CORDINATE + ", " +
            Text.TEXT + " FROM " + Note.NOTE_TABLE + " JOIN " + Coordinate.COORDINATE_TABLE +
            " ON " + Note.ID_NOTE + " = " + Coordinate.ID_NOTE + " JOIN " + Text.TEXT_TABLE +
            " ON " + Note.ID_NOTE + " = " + Text.ID_NOTE +
            " WHERE " + Note.ID_USER + " = ?";

}
