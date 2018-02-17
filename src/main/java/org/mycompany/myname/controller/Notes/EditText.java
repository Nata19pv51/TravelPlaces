package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNoteDao;
import org.mycompany.myname.model.entity.DisplayNote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EditText extends HttpServlet {
        private int idText;

    public int getIdText() {
        return idText;
    }

    public void setIdText(int idText) {
        this.idText = idText;
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String text = httpServletRequest.getParameter("textNote");
        String id_str = httpServletRequest.getParameter("idNote");
        DisplayNote note = new DisplayNote();
        int id = Integer.parseInt(id_str);
        idText = id;
        note.setNoteId(id);
        note.setText(text);
        JDBCDisplayNoteDao jdbcDisplayNoteDao = new JDBCDisplayNoteDao();
        try {
            jdbcDisplayNoteDao.update(note);

//            JDBCDisplayNote dnote = JDBCDisplayNote.getNoteByID(id);
//            Gson gson = new Gson();
//            String jsonString = gson.toJson(dnote);
//            System.out.println(jsonString);
//            httpServletResponse.getWriter().print(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }

//    }

    }

//    @Override
//    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
//        JDBCDisplayNote dnote =  JDBCDisplayNote.getNoteByID(idText);
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(dnote);
//        System.out.println(jsonString);
//        httpServletResponse.getWriter().print(jsonString);
//    }
}
