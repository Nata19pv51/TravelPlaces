package org.mycompany.myname.controller;

import org.mycompany.myname.constants.TableParameters;
import org.mycompany.myname.model.dao.*;
import org.mycompany.myname.model.dao.factory.DaoFactory;
import org.mycompany.myname.model.entity.*;

import java.sql.Connection;
import java.util.List;

public class FindAll {
    public Connection connection;
    public int id;

    public List<Route> getRoute() {
        DaoFactory factory = DaoFactory.getInstance();
        IRouteDao dao = factory.createRouteDao();
        List<Route> list = dao.findAll(id);
        return list;
    }

    public List<Note> getNote(int id){
        DaoFactory factory = DaoFactory.getInstance();
        INoteDao dao = factory.createNoteDao();
        List<Note> list = dao.findAll(id);
        return list;
    }

    public List<User> getUser(){
        DaoFactory factory = DaoFactory.getInstance();
        IUserDao dao = factory.createUserDao();
        List<User> list = dao.findAll();
        return list;
    }

    public List<RouteNote> getRouteNote(){
        DaoFactory factory = DaoFactory.getInstance();
        IRouteNoteDao dao = factory.createRouteNoteDao();
        List<RouteNote> list = dao.findAll(id);
        return list;
    }

    public List<NotePhoto> getNotePhoto(){
        DaoFactory factory = DaoFactory.getInstance();
        INotePhotoDao dao = factory.createNotePhotoDao();
        List<NotePhoto> list = dao.findAll(id);
        return list;
    }

    public List<Text> getText(){
        DaoFactory factory = DaoFactory.getInstance();
        ITextDao dao = factory.createTextDao();
        List<Text> list = dao.findAll(id);
        return list;
    }

    public List<Coordinate> getCoordinate(){
        DaoFactory factory = DaoFactory.getInstance();
        ICoordinateDao dao = factory.createCoordinateDao();
        List<Coordinate> list = dao.findAll(id);
        return list;
    }

    public List<SharedNote> getSharedNote(){
        DaoFactory factory = DaoFactory.getInstance();
        ISharedNoteDao dao = factory.createSharedNoteDao();
        List<SharedNote> list = dao.findAll(id);
        return list;
    }

    public List<SharedRoute> getSharedRoute(){
        DaoFactory factory = DaoFactory.getInstance();
        ISharedRouteDao dao = factory.createSharedRouteDao();
        List<SharedRoute> list = dao.findAll(id);
        return list;
    }
}
