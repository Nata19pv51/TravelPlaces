package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.IUserDao;
import org.mycompany.myname.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUserDao implements IUserDao {
    private  Connection connection;
//    public JDBCUserDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    protected User extractFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(User.ID_USER);
        String login = resultSet.getString(User.LOGIN);
        String password = resultSet.getString(User.PASSWORD);
        String email = resultSet.getString(User.EMAIL);
        String country = resultSet.getString(User.COUNTRY);
        return new User.UserBuilder()
                .setIdUser(id)
                .setLogin(login)
                .setPassword(password)
                .setEmail(email)
                .setCountry(country)
                .build();
    }

    @Override
    public void create(User user) throws SQLException {
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO user (login, password, email, country) VALUES (?, ?, ?, ?)")){
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCountry());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public User findById(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE id_user = ?")){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                User user = extractFromResultSet(resultSet);
                return user;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<User> findAll(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User user) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET login = ?, password = ?, email = ?, country = ? WHERE id_user = ?")){
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id_user = ?")){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
