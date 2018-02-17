package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import org.mycompany.myname.controller.Notes.EditText;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReplacedText extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        EditText editText = new EditText();
        int id = editText.getIdText();

        JDBCDisplayNote dnote =  JDBCDisplayNote.getNoteByID(id);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dnote);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
//
//        String text = httpServletRequest.getParameter("textNote");
//        String id_str = httpServletRequest.getParameter("idNote");
//        DisplayNote note = new DisplayNote();
//        int id = Integer.parseInt(id_str);
//        //idText = id;
//        note.setNoteId(id);
//        note.setText(text);
//        JDBCDisplayNoteDao jdbcDisplayNoteDao = new JDBCDisplayNoteDao();
//        try {
//            jdbcDisplayNoteDao.update(note);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}
