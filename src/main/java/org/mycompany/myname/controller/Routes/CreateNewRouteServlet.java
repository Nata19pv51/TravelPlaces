package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayRoutes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateNewRouteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String title = httpServletRequest.getParameter("title");
        JDBCDisplayRoutes route = new JDBCDisplayRoutes();
        //route.setName(title);
        try {
            route.create(title, 1);

            JDBCDisplayRoutes newRoute = JDBCDisplayRoutes.getRouteByID(11);
            Gson gson = new Gson();
            String jsonString = gson.toJson(newRoute);
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
