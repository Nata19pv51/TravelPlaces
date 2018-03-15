package org.mycompany.myname.controller.Authentification;

import org.mycompany.myname.model.dao.implement.JDBCUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        int id;

        JDBCUser user = new JDBCUser();
        id = user.findUser(login, password);
//        if(user.findByLoginPassword(login, password) == false){
        if(id > 0){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("userId", id);
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/homePage.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }
        else {
            RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/Authentification/registration.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }
    }
}