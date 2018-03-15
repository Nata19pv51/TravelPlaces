package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowOneRouteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String id = httpServletRequest.getParameter("id");
        int id_route = Integer.parseInt(id);
        List<JDBCDisplayNote> notes =  JDBCDisplayNote.getDisplayNotesByRouteID(id_route);
        String jsonString = "";
        if(notes.size() > 0) {
            notes.get(0).setRoutID(id_route);
            Gson gson = new Gson();
            jsonString = gson.toJson(notes);
        } else {
            jsonString = String.format("{\"routID\":%d}", id_route);
        }
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }
}
