package org.mycompany.myname.controller.Gallery;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayPhoto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class ShowAllPhotosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        int id = (int)session.getAttribute("userId");
        List<JDBCDisplayPhoto> photos = JDBCDisplayPhoto.findAllPhotosByUser(id);
        Gson gson = new Gson();
        String jsonString = gson.toJson(photos);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }
}
