package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowOneRouteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String id = httpServletRequest.getParameter("idRoute");
        int idRoute = Integer.parseInt(id);
        List<JDBCDisplayNote> notes =  JDBCDisplayNote.getDisplayNotesByRouteID(idRoute);
        Gson gson = new Gson();
        String jsonString = gson.toJson(notes);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }
}
