package org.mycompany.myname.controller.Photos;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhotosOfOneNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String idNote = httpServletRequest.getParameter("id");
        int id = Integer.parseInt(idNote);
        List<JDBCDisplayPhoto> photos =  JDBCDisplayPhoto.findPhotos(id);
        Gson gson = new Gson();
        String jsonString = gson.toJson(photos);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }
}
