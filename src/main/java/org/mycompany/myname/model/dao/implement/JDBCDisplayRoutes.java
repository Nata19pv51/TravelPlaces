package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayRoutes {
    final public static String ROUTE_TABLE = "route";
    final public static String ID_ROUTE = "id_route";
    final public static String NAME = "name";
    final public static String DATE_CREATION = "dateCreation";
    final public static String ID_USER = "id_user";

    private int idRoute;
    private String name;
    private long time;
    private int userId;

    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    static public List<JDBCDisplayRoutes> getRoutesByUserID(int userId) {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        String query = "SELECT " + ID_ROUTE + ", " + NAME + ", " + DATE_CREATION + ", " + ID_USER +
                       " FROM " + ROUTE_TABLE +
                       " WHERE " + ID_USER + " = " + userId;

        List<JDBCDisplayRoutes> routesList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {

            JDBCDisplayRoutes route;
            while (resultSet.next()) {
                route = new JDBCDisplayRoutes();
                route.setUserId(userId);
                route.setTime(resultSet.getLong(DATE_CREATION));
                route.setName(resultSet.getString(NAME));
                route.setIdRoute(resultSet.getInt(ID_ROUTE));
                routesList.add(route);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return routesList;
    }

    public void create(String title, int userId) throws Exception {
        String URL = "jdbc:mysql://localhost/Travel";
        String USER  = "root";
        long curTime = System.currentTimeMillis();
        String query =  "INSERT INTO " + ROUTE_TABLE + " (" + NAME + ", " + DATE_CREATION + ", " + ID_USER + ") VALUES (" +
                        title + ", " + curTime + ", " + userId + ")";

//// Хотите значение типа Date, с этим временем?
//        Date curDate = new Date(curTime);
//// Хотите строку в формате, удобном Вам?
//        String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
//// Хотите Date из строки, в которой дата с известным шаблоном?
//        Date parsedDate = new SimpleDateFormat("dd.MM.yyyy").parse("16.04.2004");

        try (Connection connection = DriverManager.getConnection(URL, USER, "");
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
