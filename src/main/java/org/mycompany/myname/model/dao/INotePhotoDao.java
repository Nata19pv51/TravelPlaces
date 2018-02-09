package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.Note;
import org.mycompany.myname.model.entity.NotePhoto;

public interface INotePhotoDao extends IGenericDao<NotePhoto> {
    public static final String FIND_ALL = "SELECT * FROM " + NotePhoto.PHOTO_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + NotePhoto.PHOTO_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + NotePhoto.PHOTO_TABLE + " WHERE id = ?";

    public static final String FIND_ALL_BY_ID_NOTE = "SELECT " + NotePhoto.URL_PHOTO + " FROM " +
            NotePhoto.PHOTO_TABLE + " WHERE " + NotePhoto.ID_NOTE + " = ?";

}
