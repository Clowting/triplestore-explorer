package triplestoreexplorer;

import static spark.Spark.*;

/**
 * A Triplestore web application
 * @author Raymon de Looff, Thijs Clowting
 */
public class App {

    private static String title = "A web-based Triplestore explorer";

    public App() {

    }

    /**
     * Responsible for building the required routes
     */
    private void buildRoutes() {

        // Static resources location
        staticFileLocation("/public");

        // Define routes
        get("/", (req, res) -> "Hello World");

    }

    public static void main(String[] args) {
        App app = new App();

        // Build routes
        app.buildRoutes();
    }

}
