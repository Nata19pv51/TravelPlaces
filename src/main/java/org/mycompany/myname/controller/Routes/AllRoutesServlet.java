package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayRoutes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<JDBCDisplayRoutes> nodes =  JDBCDisplayRoutes.getRoutesByUserID(1);
        Gson gson = new Gson();
        String jsonString = gson.toJson(nodes);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }
}