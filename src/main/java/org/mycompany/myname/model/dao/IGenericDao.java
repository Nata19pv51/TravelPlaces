package org.mycompany.myname.model.dao;

import java.util.List;

public interface IGenericDao <T> extends AutoCloseable{
    void create(T entity) throws Exception;
    T findById(int id);// throws NoResultFromDBException;
    List<T> findAll(int id);// throws NoResultFromDBException;
    void update(T entity) throws Exception;
    void delete(int id);
}
