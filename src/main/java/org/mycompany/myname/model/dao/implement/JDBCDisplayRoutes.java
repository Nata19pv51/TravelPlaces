package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDisplayRoutes {
    final public static String ROUTE_TABLE = "route";
    final public static String ID_ROUTE = "id_route";
    final public static String TITLE = "name";
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

    public int getMaxID(){
        String query = "SELECT MAX(id_route) FROM route";
        int maxID;
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)){
            //JDBCDisplayNote note = new JDBCDisplayNote();
            if(resultSet.next()){
                maxID = resultSet.getInt("MAX(id_route)");
                // note.setMaxID(resultSet.getInt("id_note"));
                return maxID;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    static public List<JDBCDisplayRoutes> getRoutesByUserID(int userId) {
        String query = "SELECT " + ID_ROUTE + ", " + TITLE + ", " + DATE_CREATION + ", " + ID_USER +
                       " FROM " + ROUTE_TABLE +
                       " WHERE " + ID_USER + " = " + userId +
                       " ORDER BY " + DATE_CREATION + " DESC";

        List<JDBCDisplayRoutes> routesList = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {

            JDBCDisplayRoutes route;
            while (resultSet.next()) {
                route = new JDBCDisplayRoutes();
                route.setUserId(userId);
                route.setTime(resultSet.getLong(DATE_CREATION));
                route.setName(resultSet.getString(TITLE));
                route.setIdRoute(resultSet.getInt(ID_ROUTE));
                routesList.add(route);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return routesList;
    }

    public void create(String title, int userId) throws Exception {
        long curTime = System.currentTimeMillis();
        String query =  "INSERT INTO " + ROUTE_TABLE + " (" + TITLE + ", " + DATE_CREATION + ", " + ID_USER + ") VALUES (\"" +
                        title + "\", " + curTime + ", " + userId + ")";
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
//             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS))
            preparedStatement.executeUpdate();
//            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
//                JDBCDisplayRoutes route = new JDBCDisplayRoutes();
//                if (generatedKeys.next()) {
//                    route.setIdRoute(generatedKeys.getInt(1));
//                    return route.getIdRoute();
//                }
//                else {
//                    throw new SQLException("Creating user failed, no ID obtained.");
//                }
//            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//// Хотите значение типа Date, с этим временем?
//        Date curDate = new Date(curTime);
//// Хотите строку в формате, удобном Вам?
//        String curStringDate = new SimpleDateFormat("dd.MM.yyyy").format(curTime);
//// Хотите Date из строки, в которой дата с известным шаблоном?
//        Date parsedDate = new SimpleDateFormat("dd.MM.yyyy").parse("16.04.2004");




//        java.util.Date dt = new java.util.Date();
//
//        java.text.SimpleDateFormat sdf =
//                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//        String currentTime = sdf.format(dt);

    static public JDBCDisplayRoutes getRouteByID(int routeId) {
        String query = "SELECT id_route, dateCreation, name FROM route" +
                " WHERE id_route=" + routeId;
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)){

            JDBCDisplayRoutes route = new JDBCDisplayRoutes();
            if (resultSet.next()) {
                route.setIdRoute(resultSet.getInt("id_route"));
                route.setTime(resultSet.getLong("dateCreation"));
                route.setName(resultSet.getString("name"));
                return route;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
