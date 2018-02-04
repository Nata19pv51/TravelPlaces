package org.mycompany.myname.model.dao.implement;

import org.mycompany.myname.constants.TableParameters;
import org.mycompany.myname.constants.TablesName;
import org.mycompany.myname.model.dao.DaoAbstract;
import org.mycompany.myname.model.dao.INoteDao;
import org.mycompany.myname.model.dao.Query;
import org.mycompany.myname.model.entity.Note;
import org.mycompany.myname.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class JDBCNoteDao implements INoteDao {

    private Connection connection;

    //    public JDBCNoteDao(String table, Connection connection) {
//        super(table, connection);
//    }
    public JDBCNoteDao(Connection connection) {
        this.connection = connection;
    }

    protected Note extractFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(TableParameters.Note.ID_NOTE);
        Date dateCreation = resultSet.getDate(TableParameters.Note.DATE_CREATION);
        return new Note.NoteBuilder()
                .setIdNote(id)
                .setDateCreation(dateCreation)
                .build();
    }

    @Override
    public void create(Note note) throws Exception {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO " + TablesName.NOTE +
                        " (" + TableParameters.Note.ID_NOTE + ", " +
                        TableParameters.Note.DATE_CREATION + ", " +
                        TableParameters.Note.ID_USER + ") VALUES (?, ?, ?)")) {
            ps.setInt(1, note.getIdNote());
            ps.setDate(2, note.getDateCreation());
            ps.setInt(3, note.getUser().getIdUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Note findById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("SELECT * FROM " + TablesName.NOTE + " WHERE " + TableParameters.Note.ID_NOTE + " = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Note note = extractFromResultSet(resultSet);
                return note;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Note> findAll(int id) {
        List<Note> list = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet resultSet = ps.executeQuery(Query.findAllNotesByUserId(id));
            while (resultSet.next()) {
                Note note = extractFromResultSet(resultSet);
                list.add(note);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void update(Note note) {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("UPDATE " + TablesName.NOTE + " SET " + TableParameters.Note.ID_NOTE + " = ?, " + TableParameters.Note.DATE_CREATION + " = ? WHERE " + TableParameters.Note.ID_NOTE + " = ?")) {
            preparedStatement.setInt(1, note.getIdNote());
            preparedStatement.setDate(2, note.getDateCreation());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM note WHERE id_note = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
