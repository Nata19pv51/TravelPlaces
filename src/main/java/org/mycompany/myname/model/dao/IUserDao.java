package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.User;

import java.util.List;

public interface IUserDao extends IGenericDao<User> {
    public static final String FIND_ALL = "SELECT * FROM " + User.USER_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + User.USER_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + User.USER_TABLE + " WHERE id = ?";

    List<User> findAll();
}
