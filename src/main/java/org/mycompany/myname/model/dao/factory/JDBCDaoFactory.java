package org.mycompany.myname.model.dao.factory;

import org.mycompany.myname.constants.TablesName;
import org.mycompany.myname.model.dao.*;
import org.mycompany.myname.model.dao.implement.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
//    @Override
//    public INoteDao createNoteDao(Connection connection) {
//        return new JDBCNoteDao(TablesName.NOTE, connection);
//    }
//
//    @Override
//    public IRouteDao createRouteDao(Connection connection) {
//        return new JDBCRouteDao(TablesName.ROUTE, connection);
//    }
//
//    @Override
//    public ICoordinateDao createCoordinateDao(Connection connection) {
//        return new JDBCCoordinateDao(TablesName.COORDINATE, connection);
//    }
//
//    @Override
//    public ITextDao createTextDao(Connection connection) {
//        return new JDBCTextDao(TablesName.TEXT, connection);
//    }
//
//    @Override
//    public IRouteNoteDao createRouteNoteDao(Connection connection) {
//        return new JDBCRouteNoteDao(TablesName.ROUTENOTE, connection);
//    }
//
//    @Override
//    public INotePhotoDao createNotePhotoDao(Connection connection) {
//        return new JDBCNotePhotoDao(TablesName.PHOTO, connection);
//    }
//
//    @Override
//    public IUserDao createUserDao(Connection connection) {
//        return new JDBCUserDao(TablesName.USER, connection);
//    }
//
//    @Override
//    public ISharedNoteDao createSharedNoteDao(Connection connection) {
//        return new JDBCSharedNoteDao(TablesName.SHARED_NOTE, connection);
//    }
//
//    @Override
//    public ISharedRouteDao createSharedRouteDao(Connection connection) {
//        return new JDBCSharedRouteDao(TablesName.SHARED_ROUTE, connection);
//    }

    @Override
    public INoteDao createNoteDao() {
        //return new JDBCNoteDao(TablesName.NOTE, connection);
        return new JDBCNoteDao(getConnection());
    }

    @Override
    public IRouteDao createRouteDao() {
        return new JDBCRouteDao(getConnection());
    }

    @Override
    public ICoordinateDao createCoordinateDao() {
        return new JDBCCoordinateDao(getConnection());
    }

    @Override
    public ITextDao createTextDao() {
        return new JDBCTextDao(getConnection());
    }

    @Override
    public IRouteNoteDao createRouteNoteDao() {
        return new JDBCRouteNoteDao(getConnection());
    }

    @Override
    public INotePhotoDao createNotePhotoDao() {
        return new JDBCNotePhotoDao(getConnection());
    }

    @Override
    public IUserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    @Override
    public ISharedNoteDao createSharedNoteDao() {
        return new JDBCSharedNoteDao(getConnection());
    }

    @Override
    public ISharedRouteDao createSharedRouteDao() {
        return new JDBCSharedRouteDao(getConnection());
    }

    private Connection getConnection(){
        try{
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Travel",
                    "root",
                    "");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
