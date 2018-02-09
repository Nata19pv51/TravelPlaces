package org.mycompany.myname.model.dao.factory;

import org.mycompany.myname.model.dao.*;

import java.sql.Connection;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;
//    public abstract INoteDao createNoteDao(Connection connection);
//    public abstract IRouteDao createRouteDao(Connection connection);
//    public abstract ICoordinateDao createCoordinateDao(Connection connection);
//    public abstract ITextDao createTextDao(Connection connection);
//    public abstract IRouteNoteDao createRouteNoteDao(Connection connection);
//    public abstract INotePhotoDao createNotePhotoDao(Connection connection);
//    public abstract IUserDao createUserDao(Connection connection);
//    public abstract ISharedNoteDao createSharedNoteDao(Connection connection);
//    public abstract ISharedRouteDao createSharedRouteDao(Connection connection);

    public abstract INoteDao createNoteDao();
    public abstract IRouteDao createRouteDao();
    public abstract ICoordinateDao createCoordinateDao();
    public abstract ITextDao createTextDao();
    public abstract IRouteNoteDao createRouteNoteDao();
    public abstract INotePhotoDao createNotePhotoDao();
    public abstract IUserDao createUserDao();
    public abstract ISharedNoteDao createSharedNoteDao();
    public abstract ISharedRouteDao createSharedRouteDao();
    public abstract IDisplayNoteDao createDisplayNoteDao();

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            synchronized (DaoFactory.class){
                if(daoFactory == null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
