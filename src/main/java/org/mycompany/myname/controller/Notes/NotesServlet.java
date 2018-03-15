package org.mycompany.myname.controller.Notes;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.entity.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class NotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        int id = (int)session.getAttribute("userId");

        List<JDBCDisplayNote> notes =  JDBCDisplayNote.getDisplayNotesByUserID(id);
        Gson gson = new Gson();
        String jsonString = gson.toJson(notes);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);

        //        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/Notes/notes.jsp");
//        rd.forward(httpServletRequest,httpServletResponse);

//        FindAll getAll = new FindAll();
//        List<Note> noteList = getAll.getNote(1);
//
//        String json = new Gson().toJson(noteList);
       // json.writeJSONString(httpServletRequest.getWriter());

       // httpServletResponse.getWriter().print(json);

//        FindAll getAll = new FindAll();
//        List<Note> noteList = getAll.getNote();
//
//        String json = new Gson().toJson(noteList);
//        int i = 1;
////        JsonObject jsonData = new JsonObject();
////        for (Note item : noteList) {
////            jsonData.add("i", "item.getIdNote()");
////            i++;
////        }
//
//
//        System.out.println("JSON data: "+jsonData.toString());
//        //Gson gson = new Gson();

//        JSONObject obj = new org.json.JSONObject();
//        JsonObject json = new JsonObject();
//        json.put("Mobile", 9999988888);
    }
}
