package triplestoreexplorer;

import static spark.Spark.*;

import com.github.kevinsawicki.http.HttpRequest;
import triplestoreexplorer.controller.*;
import triplestoreexplorer.model.ViewModel;
import triplestoreexplorer.template.HandlebarsTemplateEngine;

/**
 * A Triplestore web application
 * @author Raymon de Looff, Thijs Clowting
 */
public class App {

    /**
     * Responsible for building the required routes
     */
    private void buildRoutes() {

        // Static resources location
        staticFileLocation("/public");

        // Define routes
        get("/", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            IndexViewController indexViewController = new IndexViewController(viewModel, "index");

            // Execute
            indexViewController.dispatch(request);

            return indexViewController.render();
        }, new HandlebarsTemplateEngine());

        // Data
        get("/data/:dataset/:page", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DataViewController dataViewController = new DataViewController(viewModel, "data");

            // Execute
            dataViewController.dispatch(request);

            return dataViewController.render();
        }, new HandlebarsTemplateEngine());

        get("/data/:dataset/:method/:spo/:value", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DataDetailViewController dataDetailViewController = new DataDetailViewController(viewModel, "data");

            // Execute
            dataDetailViewController.dispatch(request);

            return dataDetailViewController.render();
        }, new HandlebarsTemplateEngine());

        // Datasets
        get("/datasets", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DatasetsViewController datasetsViewController = new DatasetsViewController(viewModel, "datasets");

            // Execute
            datasetsViewController.dispatch(request);

            return datasetsViewController.render();
        }, new HandlebarsTemplateEngine());

        get("/datasets/add", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            DatasetsAddViewController datasetsAddViewController = new DatasetsAddViewController(viewModel, "add-datasets");

            // Execute
            datasetsAddViewController.dispatch(request);

            return datasetsAddViewController.render();
        }, new HandlebarsTemplateEngine());

        post("/datasets/add", (request, response) -> {
            int code = HttpRequest.post("http://localhost:3030/$/datasets").send(request.body()).code();
            response.redirect("/datasets");
            return null;
        });

        get("/datasets/remove/:dataset", (request, response) -> {
            HttpRequest deleteRequest = HttpRequest.delete("http://localhost:3030/$/datasets/" + request.params(":dataset"));
            response.status(deleteRequest.code());

            return deleteRequest.body();
        });

        // Query
        get("/query", (request, response) -> {
            ViewModel viewModel = new ViewModel();
            QueryViewController queryViewController = new QueryViewController(viewModel, "query");

            // Execute
            queryViewController.dispatch(request);

            return queryViewController.render();
        }, new HandlebarsTemplateEngine());

        get("/query/execute/:method/:dataset", (request, response) -> {
            String query = java.net.URLEncoder.encode(request.queryParams("query"), "UTF-8");
            HttpRequest queryRequest = HttpRequest.get("http://localhost:3030/" + request.params(":dataset") + "/query?" + request.params(":method") + "=" + query);
            response.status(queryRequest.code());

            return queryRequest.body();
        });

    }

    public static void main(String[] args) {
        App app = new App();

        // Build routes
        app.buildRoutes();
    }

}
