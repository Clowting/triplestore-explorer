package triplestoreexplorer;

import static spark.Spark.*;

import spark.ModelAndView;
import triplestoreexplorer.controller.DatasetsViewController;
import triplestoreexplorer.model.DatasetsViewModel;
import triplestoreexplorer.model.ViewModel;
import triplestoreexplorer.template.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A Triplestore web application
 * @author Raymon de Looff, Thijs Clowting
 */
public class App {

    private static String title = "A web-based Triplestore explorer";
    private String dataStore;

    public App() {
        this.dataStore = "http://localhost:3030/elvisimp/";
    }

    /**
     * Responsible for building the required routes
     */
    private void buildRoutes() {

        // Static resources location
        staticFileLocation("/public");

        // Define routes
        get("/", (req, res) -> "Hello World");

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Sam");

        // Datasets
        /*get("/datasets", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DatasetsViewController datasetsViewController = new DatasetsViewController(viewModel, "datasets");

            // Set parameters
            //datasetsViewController;

            response.

            return new ModelAndView(map, "base"), new HandlebarsTemplateEngine();
        });*/

        // Handlebars test
        get("/test", (request, response) -> new ModelAndView(map, "base"), new HandlebarsTemplateEngine());

    }

    public static void main(String[] args) {
        App app = new App();

        // Build routes
        app.buildRoutes();
    }

}
