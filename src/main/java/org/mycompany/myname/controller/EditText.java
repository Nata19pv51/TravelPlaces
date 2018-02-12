package org.mycompany.myname.controller;

import org.mycompany.myname.model.dao.implement.JDBCDisplayNoteDao;
import org.mycompany.myname.model.entity.DisplayNote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditText extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String textNote = httpServletRequest.getParameter("textNote");
        String id_str = httpServletRequest.getParameter("id");
        DisplayNote note = new DisplayNote();
        int id = Integer.parseInt(id_str);
        note.setNoteId(id);
        note.setText(textNote);
        JDBCDisplayNoteDao jdbcDisplayNoteDao = new JDBCDisplayNoteDao();
        try {
            jdbcDisplayNoteDao.update(note);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        String textNote = httpServletRequest.getParameter("textNote");
//        String id_str = httpServletRequest.getParameter("id");
//        DisplayNote note = new DisplayNote();
//        int id = Integer.parseInt(id_str);
//        note.setNoteId(id);
//        note.setText(textNote);
//        JDBCDisplayNoteDao jdbcDisplayNoteDao = new JDBCDisplayNoteDao();
//        try {
//            jdbcDisplayNoteDao.update(note);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
