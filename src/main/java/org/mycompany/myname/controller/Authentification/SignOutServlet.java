package org.mycompany.myname.controller.Authentification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        //********************************************************************************
        HttpSession session = httpServletRequest.getSession();
        session.removeAttribute("userId");
        //*********************************************************************************

        RequestDispatcher rd=getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(httpServletRequest,httpServletResponse);
    }
}
