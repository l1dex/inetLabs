package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

@WebServlet(name = "galleryServlet", urlPatterns = {"/galleryServlet"})
public class GalleryServlet extends HttpServlet {
    public GalleryServlet(){}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("login") == null) resp.sendRedirect("/signPage.jsp");

        String pathDir = "src/main/webapp/images/";
        File folder = new File(pathDir);

        String[] files = folder.list((folder1, name) -> name.endsWith(".png"));
        resp.getWriter().println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Gallery</title>\n" +
                "  </head>\n" +
                "  <body>");
        for ( String fileName : files ) {
            File file = new File(pathDir + fileName);

            resp.getWriter().println("<td>");
            resp.getWriter().println("<a href=\"images/" + fileName +"\">");
            resp.getWriter().println("<img src=\"images/" + fileName + "\" width='500' />");
            resp.getWriter().println("</a>");
            resp.getWriter().println("</td>");
        }
        resp.getWriter().println("</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("login") == null) resp.sendRedirect("/signPage.jsp");
        System.out.println(req.getParameter("test"));
        String pathDir = "src/main/webapp/images/";
        File folder = new File(pathDir);
        String[] files = folder.list((folder1, name) -> name.endsWith(".png"));

        for(String fileName : files){
            File file = new File(pathDir + fileName);
            System.out.println("Can write" + file.canWrite());
            if(file.delete() == true){
                System.out.println("File delete");
            }

        }
        req.getRequestDispatcher("/content.jsp").forward(req,resp);

    }
}
