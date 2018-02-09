package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.RouteNote;

public interface IRouteNoteDao extends IGenericDao<RouteNote> {
    public static final String FIND_ALL = "SELECT * FROM " + RouteNote.ROUTENOTE_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + RouteNote.ROUTENOTE_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + RouteNote.ROUTENOTE_TABLE + " WHERE id = ?";


}
