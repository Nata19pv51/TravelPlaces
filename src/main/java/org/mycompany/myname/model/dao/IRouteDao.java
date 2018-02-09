package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.Route;
import org.mycompany.myname.model.entity.User;

public interface IRouteDao extends IGenericDao<Route> {
    public static final String FIND_ALL = "SELECT * FROM " + Route.ROUTE_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + Route.ROUTE_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + Route.ROUTE_TABLE + " WHERE id = ?";

    public static final String FIND_ALL_ROUTES_BY_USER = "SELECT " + Route.NAME + ", " +
    Route.DATE_CREATION + " FROM " + Route.ROUTE_TABLE +
            " WHERE " + Route.ID_USER + " = ?";
}
