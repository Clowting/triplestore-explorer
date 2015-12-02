package triplestoreexplorer.controller;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.Query;
import spark.Request;
import triplestoreexplorer.model.ViewModel;

/**
 * This is the controller for the browse webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DataViewController extends ViewController {

    /**
     * The default constructor for the browse webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public DataViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    /**
     * Adds request data to the model
     * @param request The request object
     */
    private void addRequestDataToModel(Request request) {
        model.addData("dataset", request.params(":dataset"));
        model.addData("page", request.params(":page"));
    }

    @Override
    public void dispatch(Request request) {
        setTitle("Browse data");

        // Add request data to model
        addRequestDataToModel(request);

        // Query building
        SelectBuilder sb = new SelectBuilder()
                .addVar( "*" )
                .addWhere( "?s", "?p", "?o" );

        Query q = sb.build();

    }
}