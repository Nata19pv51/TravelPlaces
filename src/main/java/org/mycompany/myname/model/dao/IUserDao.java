package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.User;

import java.util.List;

public interface IUserDao extends IGenericDao<User> {
    List<User> findAll();
}
