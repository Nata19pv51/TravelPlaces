package org.mycompany.myname.controller.Gallery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GalleryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        RequestDispatcher rd=getServletContext().getRequestDispatcher("/WEB-INF/Gallery/gallery.jsp");
        rd.forward(httpServletRequest,httpServletResponse);
    }
}
