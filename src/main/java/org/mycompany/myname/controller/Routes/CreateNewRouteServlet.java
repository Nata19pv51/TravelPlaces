package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayRoutes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreateNewRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String title = httpServletRequest.getParameter("title");
        int maxID;
        JDBCDisplayRoutes route = new JDBCDisplayRoutes();
        try {
            HttpSession session = httpServletRequest.getSession();
            int id = (int)session.getAttribute("userId");
            route.create(title, id);
            //maxID = route.getMaxID();
            List<JDBCDisplayRoutes> notes =  JDBCDisplayRoutes.getRoutesByUserID(id);
            Gson gson = new Gson();
            String jsonString = gson.toJson(notes);
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
//            JDBCDisplayRoutes newRoute = JDBCDisplayRoutes.getRouteByID(maxID);
//            Gson gson = new Gson();
//            String jsonString = gson.toJson(newRoute);
//            System.out.println(jsonString);
//            httpServletResponse.getWriter().print(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
