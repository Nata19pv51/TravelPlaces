package org.mycompany.myname.controller.Notes;

import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OpenOneNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
       // httpServletResponse.setContentType("text/html");
       // httpServletRequest.setAttribute("name", "value234dfg23345243");
        try {
            httpServletRequest.getRequestDispatcher("WEB-INF/Notes/oneNote.jsp").include(httpServletRequest, httpServletResponse);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
