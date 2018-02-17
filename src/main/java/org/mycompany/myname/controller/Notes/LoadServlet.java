package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNoteDao;
import org.mycompany.myname.model.entity.DisplayNote;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
//        httpServletResponse.getWriter().print("Hello from servlet");

//        FindAll getAll = new FindAll();
//        List<Note> noteList = getAll.getNote(1);
//
//        Gson gson = new Gson();
//        String result = gson.toJson(noteList);

//        FindAll getAll = new FindAll();
//        List<DisplayNote> notes =  getAll.getDisplayNote(1);
//        Gson gson = new Gson();
//        String jsonString = gson.toJson(notes);
//        httpServletResponse.getWriter().print(jsonString);

        List<JDBCDisplayNote> nodes =  JDBCDisplayNote.getDisplayNotesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(nodes);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);



        //System.out.println(jsonString);
    }
}
