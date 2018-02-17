package org.mycompany.myname.controller.Authentification;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/homePage.jsp");
        rd.forward(httpServletRequest,httpServletResponse);
    }
}
