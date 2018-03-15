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

public class AllRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        int id = (int)session.getAttribute("userId");
        List<JDBCDisplayRoutes> routes =  JDBCDisplayRoutes.getRoutesByUserID(id);
        Gson gson = new Gson();
        String jsonString;
        if(routes.isEmpty()){
            jsonString = "{\"routes\": \"null\"}";
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
        }else{
            jsonString = gson.toJson(routes);
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
        }

    }
}