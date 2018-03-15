package org.mycompany.myname.controller.Authentification;

import com.google.gson.Gson;
//import org.json.simple.JSONObject;
import org.mycompany.myname.model.dao.implement.JDBCUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RegisteredServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        String email = httpServletRequest.getParameter("email");
        JDBCUser jdbcUser = new JDBCUser();
        jdbcUser.setLogin(login);
        jdbcUser.setPassword(password);
        jdbcUser.setEmail(email);

        JDBCUser userFromDB = jdbcUser.findByLogin(login);
        if (userFromDB == null || !jdbcUser.getLogin().equals(userFromDB.getLogin())) {
            jdbcUser.create(jdbcUser);

            //*************************************************************************************
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId", jdbcUser.getIdUser());
            //*************************************************************************************
//            RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/homePage.jsp");
//            rd.forward(httpServletRequest,httpServletResponse);
            String jsonString = "{\"userAbsent\": \"yes\"}";
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
        } else {
            String jsonString = "{\"userAbsent\": \"no\"}";
            System.out.println(jsonString);
            httpServletResponse.getWriter().print(jsonString);
        }
    }
}
