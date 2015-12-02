package triplestoreexplorer.controller;

import spark.Request;
import triplestoreexplorer.formatter.Formatter;
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
        model.addData("data", Formatter.jsonStringToHashMap(request.attribute("jsonResponse")));
    }

    @Override
    public void dispatch(Request request) {
        setTitle("Browse data");

        // Add request data to model
        addRequestDataToModel(request);


    }
}