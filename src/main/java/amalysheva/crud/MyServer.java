package amalysheva.crud;
import amalysheva.crud.servlets.HTMLServlet;
import amalysheva.crud.servlets.SignInServlet;
import amalysheva.crud.servlets.SignUpServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class MyServer {
    public static void start() throws Exception {
        Server server = new Server(8080);
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(SignInServlet.class, "/signin");
        contextHandler.addServlet(SignUpServlet.class, "/signup");
        contextHandler.addServlet(HTMLServlet.class, "/"); //root

        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}
