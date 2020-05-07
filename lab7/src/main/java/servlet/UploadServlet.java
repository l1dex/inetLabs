package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(name = "uploadServlet", urlPatterns = {"/uploadServlet"})
public class UploadServlet extends HttpServlet {
    public UploadServlet(){}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Parse the request
            List<FileItem> items = upload.parseRequest(req);

            for(FileItem item : items) {
                if(item.getSize() < 2_000_000) {
                    File file = new File("C:\\Users\\Кирилл\\Desktop\\inetProg\\lab7\\src\\main\\webapp\\images\\" + item.getName().charAt(0) + new Date().getTime() + ".png");
                    item.write(file);
                }
            }
            resp.sendRedirect("content.jsp");
        }
        catch (FileUploadException e){

        } catch (Exception e) {
            resp.sendRedirect("content.jsp");
        }
    }
}
