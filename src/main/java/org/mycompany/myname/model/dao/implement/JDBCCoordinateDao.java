package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.ICoordinateDao;
import org.mycompany.myname.model.entity.Coordinate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCCoordinateDao implements ICoordinateDao {
    private Connection connection;
//    public JDBCCoordinateDao(String table, Connection connection) {
//        super(table, connection);
//    }
    public JDBCCoordinateDao(Connection connection) {
        this.connection = connection;
    }

    protected Coordinate extractFromResultSet(ResultSet resultSet) throws SQLException {
//        int id = resultSet.getInt(TableParameters.Coordinate.ID_NOTE);
        double coordinate = resultSet.getDouble(Coordinate.CORDINATE);
        return new Coordinate.CoordinateBuilder()
                .setCoordinate(coordinate)
                .build();
    }

    @Override
    public void create(Coordinate entity) throws Exception {

    }

    @Override
    public Coordinate findById(int id) {
        return null;
    }

    @Override
    public List<Coordinate> findAll(int id) {
        return null;
    }

    @Override
    public void update(Coordinate entity) throws Exception {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() throws Exception {

    }
}
