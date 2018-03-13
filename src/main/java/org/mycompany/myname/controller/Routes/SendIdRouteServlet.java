package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SendIdRouteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String idRoute = httpServletRequest.getParameter("routID");
//        int id = Integer.parseInt(idRoute);
        String jsonString = String.format("{\"idRoute\": %d}", idRoute);
        System.out.println(jsonString);
        httpServletResponse.getWriter().print(jsonString);
    }


}
