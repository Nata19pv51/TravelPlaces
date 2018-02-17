package org.mycompany.myname.controller.Authentification;

import org.mycompany.myname.model.dao.implement.JDBCUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");

        JDBCUser user = new JDBCUser();
        if(user.findByLoginPassword(login, password) == false){
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }
        else {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/homePage.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }
    }
}