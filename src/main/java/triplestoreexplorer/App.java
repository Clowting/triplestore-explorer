package triplestoreexplorer;

import static spark.Spark.*;

import spark.ModelAndView;
import triplestoreexplorer.controller.DatasetsPageController;
import triplestoreexplorer.model.DatasetsPageModel;
import triplestoreexplorer.template.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A Triplestore web application
 * @author Raymon de Looff, Thijs Clowting
 */
public class App {

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

        Map map = new HashMap();
        map.put("name", "Sam");

        // Datasets
        DatasetsPageModel datasetsPageModel = new DatasetsPageModel();
        DatasetsPageController datasetsPageController = new DatasetsPageController();
        get("/datasets", (request, response) -> new ModelAndView(map, "datasets"), new HandlebarsTemplateEngine());

        // Handlebars test
        get("/test", (rq, rs) -> new ModelAndView(map, "base"), new HandlebarsTemplateEngine());

    }

    public static void main(String[] args) {
        App app = new App();

        // Build routes
        app.buildRoutes();
    }

}
