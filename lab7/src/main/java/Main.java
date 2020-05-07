import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import servlet.GalleryServlet;
import servlet.RegServlet;
import servlet.SignServlet;
import servlet.UploadServlet;

import javax.xml.soap.SAAJResult;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. Creating the server on port 8080
        Server server = new Server(8080);

        // 2. Creating the WebAppContext for the created content
        WebAppContext ctx = new WebAppContext();
        ctx.setResourceBase("src/main/webapp");
        ctx.setContextPath("");
        //Adding servlets
        ctx.addServlet(new ServletHolder(new SignServlet()),"/signServlet");
        ctx.addServlet(new ServletHolder(new RegServlet()),"/regServlet");
        ctx.addServlet(new ServletHolder(new UploadServlet()),"/uploadServlet");
        ctx.addServlet(new ServletHolder(new GalleryServlet()),"/galleryServlet");

        //3. Including the JSTL jars for the webapp.
        ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");

        //4. Enabling the Annotation based configuration
        org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");


        //5. Setting the handler and starting the Server
        server.setHandler(ctx);
        server.start();
        server.join();

    }

}
