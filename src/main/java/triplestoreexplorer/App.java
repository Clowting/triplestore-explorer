package triplestoreexplorer;

import static spark.Spark.*;

import triplestoreexplorer.controller.DatasetsViewController;
import triplestoreexplorer.model.ViewModel;
import triplestoreexplorer.template.HandlebarsTemplateEngine;

/**
 * A Triplestore web application
 * @author Raymon de Looff, Thijs Clowting
 */
public class App {

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

        // Datasets
        get("/datasets", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DatasetsViewController datasetsViewController = new DatasetsViewController(viewModel, "datasets");

            // Execute
            datasetsViewController.dispatch(request);

            return datasetsViewController.render();
        }, new HandlebarsTemplateEngine());

    }

    public static void main(String[] args) {
        App app = new App();

        // Build routes
        app.buildRoutes();
    }

}
