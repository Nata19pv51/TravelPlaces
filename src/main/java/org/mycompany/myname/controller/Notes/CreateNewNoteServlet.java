package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String text = httpServletRequest.getParameter("text");
        String coordinate = httpServletRequest.getParameter("coordinate");
        String photo = httpServletRequest.getParameter("photo");
        double location = Double.parseDouble(coordinate);
        int maxID;
        JDBCDisplayNote note = new JDBCDisplayNote();
        try{
            note.createNote(1);
            maxID = note.getMaxID();
            note.createText(maxID, text);
            note.createCoordinate(maxID, location);
           JDBCDisplayNote note2 = JDBCDisplayNote.getNoteByID(maxID);
            Gson gson = new Gson();
            String jsonString = gson.toJson(note2);
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
