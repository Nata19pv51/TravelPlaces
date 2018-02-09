package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.Route;
import org.mycompany.myname.model.entity.SharedRoute;
import org.mycompany.myname.model.entity.User;

public interface ISharedRouteDao extends IGenericDao<SharedRoute>{
    public static final String FIND_ALL = "SELECT * FROM " + SharedRoute.SHARED_ROUTE_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + SharedRoute.SHARED_ROUTE_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + SharedRoute.SHARED_ROUTE_TABLE + " WHERE id = ?";

    public static final String FIND_ALL_SHARED_ROUTES_BY_USER =
            "SELECT " + Route.ID_ROUTE + ", " + Route.DATE_CREATION + ", " + Route.NAME +
            " FROM " + SharedRoute.SHARED_ROUTE_TABLE + " JOIN " + Route.ROUTE_TABLE +
            " ON " + SharedRoute.ID_ROUTE + " = " + Route.ID_ROUTE +
            "WHERE " + SharedRoute.ID_USER + " = ?";

}
