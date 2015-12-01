package triplestoreexplorer.controller;

import spark.Request;
import triplestoreexplorer.model.ViewModel;

/**
 * This is the controller for the query webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class QueryViewController extends ViewController {

    /**
     * The default constructor for the query webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public QueryViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    /**
     * Called on page load, use this method to set up the data array that needs to be passed to the template
     *
     * @param request
     */
    @Override
    public void dispatch(Request request) {
        setTitle("SPARQL Query");


    }

}
