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
        String idNote =  httpServletRequest.getParameter("idNote");
        int id = Integer.parseInt(idNote);
        JDBCDisplayNote note =  JDBCDisplayNote.getNoteByID(id);

        String html = "<jsp:include page=\"head.jsp\"/>" +
                "<jsp:include page=\"nav.jsp\"/>";
        html += "<div class=\"divNotes mb-2\">" +
                "<input type=\"hidden\" class=\"idNote\" name=\"idNote\" value=\"" + note.getNoteId() + "\"/>" +
                "<h4 class=\"col-sm-4 timeNote\">" + note.getTime() + "</h4>" +
                "<div class=\"textNote\" name=\"textNote\">" + note.getText() + "</div>" +
                "</div>";
        html += "<jsp:include page=\"script.jsp\"/>" +
                "<script src=\"resources/js/loadOneNote.js\"></script>" +
                "</body>" +
                "</html>";

        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.print(html);
        printWriter.close();
//        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/Notes/notes.jsp");
//        rd.forward(httpServletRequest,httpServletResponse);
    }
}
