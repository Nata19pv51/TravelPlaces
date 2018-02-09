package org.mycompany.myname.model.dao;
import org.mycompany.myname.model.entity.Coordinate;

public interface ICoordinateDao extends IGenericDao<Coordinate>  {
    public static final String FIND_ALL = "SELECT * FROM " + Coordinate.COORDINATE_TABLE;
    public static final String DELETE_BY_ID = "DELETE FROM " + Coordinate.COORDINATE_TABLE + " WHERE id = ?";
    public static final String FIND_BY_ID = "SELECT * FROM " + Coordinate.COORDINATE_TABLE + " WHERE id = ?";




}
