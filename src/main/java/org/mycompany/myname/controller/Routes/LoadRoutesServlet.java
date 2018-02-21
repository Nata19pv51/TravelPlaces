package org.mycompany.myname.controller.Routes;

import com.google.gson.Gson;
import org.mycompany.myname.model.dao.implement.JDBCDisplayRoutes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoadRoutesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/Routes/routes.jsp");
        rd.forward(httpServletRequest,httpServletResponse);
    }
}
