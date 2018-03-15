package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.DBUtil;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.User;

import java.sql.*;

public class JDBCUser {
    private int idUser;
    private String login;
    private String password;
    private String email;



    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean findByLoginPassword(String login, String password) {
        String query = "SELECT id_user FROM user WHERE login = \"" + login
                + "\" AND password = \"" + password + "\"";
//        String query = "SELECT id_user, login, password FROM user WHERE login = ? AND password = ?";
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             //PreparedStatement ps = connection.prepareStatement(query))
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {
            if (resultSet.wasNull()) {
                return true;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    public int findUser(String login, String password) {
        int id;
        String query = "SELECT id_user FROM user WHERE login = \"" + login
                + "\" AND password = \"" + password + "\"";
        try (Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
             Statement ps = connection.createStatement();
             ResultSet resultSet = ps.executeQuery(query)) {
            if (resultSet.next()) {
                id = resultSet.getInt("id_user");
                return id;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return 0;
    }

    public void create(JDBCUser user) {
        try(Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO user(login, password, email) VALUES (?,?,?)")){
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public JDBCUser findByLogin(String login){
        //JDBCUser user = new JDBCUser();
        try(Connection connection = DBUtil.getConnection(DBUtil.DEFAULT_DB);
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT login, password, email FROM user WHERE login = ?")){
            ps.setString(1, login);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                JDBCUser user  = new JDBCUser();
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
