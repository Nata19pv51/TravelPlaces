package org.mycompany.myname.controller.Notes;

import com.google.gson.Gson;
import jdk.nashorn.internal.scripts.JD;
import org.mycompany.myname.model.dao.implement.JDBCDisplayNote;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNewNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        int id = (int)session.getAttribute("userId");

        String routID = httpServletRequest.getParameter("routID");
        String text = httpServletRequest.getParameter("text");
        String coordinateLat = httpServletRequest.getParameter("Lat");
        String coordinateLng = httpServletRequest.getParameter("Lng");
        //String photo = httpServletRequest.getParameter("photo");
        //String[] photo = httpServletRequest.getParameterValues("photo");
        String photo = httpServletRequest.getParameter("photo");
        System.out.println(photo);

        String[] r = divide(photo);
        for (int i = 0; i < r.length; i++) {
            System.out.println('"' + r[i] + '"');
        }

        double lat = Double.parseDouble(coordinateLat);
        double lng = Double.parseDouble(coordinateLng);
        int routeID = Integer.parseInt(routID);
        int maxID;
        JDBCDisplayNote note = new JDBCDisplayNote();
        //JDBCDisplayPhoto jdbcDisplayPhoto = new JDBCDisplayPhoto();
        try{
            note.createNote(id);
            maxID = note.getMaxID();
            note.createText(maxID, text);
            note.createCoordinate(maxID, lat, lng);
            note.createRouteNote(routeID, maxID);
            for (String item : r) {
                //jdbcDisplayPhoto.savePhoto(maxID, item);
                note.savePhoto(maxID, item);
                System.out.println(maxID + ", " + item);
            }
            if(routeID == -1){
                List<JDBCDisplayNote> note2 = JDBCDisplayNote.getDisplayNotesByUserID(id);
                Gson gson = new Gson();
                String jsonString = gson.toJson(note2);
                System.out.println(jsonString);
                httpServletResponse.getWriter().print(jsonString);
            }
            else{
                List<JDBCDisplayNote> notes = JDBCDisplayNote.getDisplayNotesByRouteID(routeID);
                Gson gson = new Gson();
                String jsonString = gson.toJson(notes);
                System.out.println(jsonString);
                httpServletResponse.getWriter().print(jsonString);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[] divide(String s) {
        ArrayList<String> tmp = new ArrayList<String>();
        int i = 0;
        boolean f = false;

        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ',') {
                if (j > i) {
                    tmp.add(s.substring(i, j));
                }
                i = j + 1;
            }
        }
        if (i < s.length()) {
            tmp.add(s.substring(i));
        }
        return tmp.toArray(new String[tmp.size()]);
    }
}
