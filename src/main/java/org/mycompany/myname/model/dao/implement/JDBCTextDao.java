package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.model.dao.ITextDao;
import org.mycompany.myname.model.entity.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JDBCTextDao implements ITextDao {

    private  Connection connection;
//    public JDBCTextDao(String table, Connection connection) {
//        super(table, connection);
//    }

    public JDBCTextDao(Connection connection) {
        this.connection = connection;
    }

    protected Text extractFromResultSet(ResultSet resultSet) throws SQLException {
        String text = resultSet.getString(Text.TEXT);
        return new Text.TextBuilder()
                .setText(text)
                .build();
    }

    @Override
    public void create(Text text) throws Exception {
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO " + Text.TEXT_TABLE + " (" + Text.ID_NOTE + ", " + Text.TEXT + ") VALUES (?, ?)")){
            ps.setInt(1, text.getNote().getIdNote());
            ps.setString(2, text.getText());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Text findById(int id) {
        return null;
    }

    @Override
    public List<Text> findAll(int id) {
        return null;
    }

//    @Override
//    public List<Text> findAll(int id) {
//        return super.findAll(id);
//    }

    @Override
    public void update(Text text) throws Exception {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE " + Text.TEXT_TABLE + " SET " + Text.TEXT + " = ? WHERE " + Text.ID_NOTE + " = ?")){
            preparedStatement.setString(1, text.getText());
            preparedStatement.setDouble(2, text.getNote().getIdNote());
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM " + Text.TEXT_TABLE + " WHERE " + Text.ID_NOTE + " = ?")){
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
