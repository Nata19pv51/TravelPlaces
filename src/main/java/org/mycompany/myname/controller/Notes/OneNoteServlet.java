package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        String idNote = httpServletRequest.getParameter("id");
//        String time = httpServletRequest.getParameter("date");
//        String textNote = httpServletRequest.getParameter("text");

        int id = Integer.parseInt(idNote);
        JDBCDisplayNote dnote =  JDBCDisplayNote.getNoteByID(id);
        Gson gson = new Gson();
        String jsonString = gson.toJson(dnote);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);


//        Gson gson = new Gson();
//        String[] array = {id, time, textNote};
//        String jsonString = gson.toJson(array);
//        System.out.println(jsonString);
//        httpServletResponse.getWriter().print(jsonString);

//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/oneNote.jsp");
//        rd.forward(httpServletRequest,httpServletResponse);
    }
}
