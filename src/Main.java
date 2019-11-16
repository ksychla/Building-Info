import Building_Info.*;
import Utils.JsonParser;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Main class for running the program
 * Will work with the REST api later
 */
public class Main {
    public static void main(String[] args){
//        BuildingComponent building = BuildingComponent.GetExamplaryBuilding();
        BuildingComponent test;
        JsonParser parser = new JsonParser();
//
//        parser.saveJson(building, "building.json");
        test = parser.loadJson("building.json");

        test.printInfo();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("jersey.config.server.provider.packages", "RestApi");

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.destroy();
        }

    }
}
