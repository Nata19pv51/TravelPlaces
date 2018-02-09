package org.mycompany.myname.model.dao;

import org.mycompany.myname.model.entity.Text;

public interface ITextDao extends IGenericDao<Text> {
    public static final String FIND_ALL = "SELECT * FROM " + Text.TEXT_TABLE;
    public static final String FIND_BY_ID = "SELECT * FROM " + Text.TEXT_TABLE + " WHERE id = ?";
    public static final String DELETE_BY_ID =  "DELETE FROM " + Text.TEXT_TABLE + " WHERE id = ?";

}
