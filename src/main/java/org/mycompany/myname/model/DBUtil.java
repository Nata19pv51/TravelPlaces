package org.mycompany.myname.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static final DBType DEFAULT_DB = DBType.SQLITE;

    // db parameters
    private static final String URL_SQLITE = "jdbc:sqlite:database/travel.db";
    private static final String URL_MYSQL = "jdbc:mysql://localhost/Travel";
    private static final String USER = "root";


    public static Connection getConnection(DBType dbType) throws SQLException {
        switch (dbType) {
            case SQLITE:
                return DriverManager.getConnection(URL_SQLITE);

            case MYSQL:
                return DriverManager.getConnection(URL_MYSQL, USER, "");
        }
        return null;
    }
}
