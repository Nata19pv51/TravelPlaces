package org.mycompany.myname.controller;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.mycompany.myname.model.entity.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class NotesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp");
        rd.forward(httpServletRequest,httpServletResponse);

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
