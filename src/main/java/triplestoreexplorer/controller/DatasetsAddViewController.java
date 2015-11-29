package triplestoreexplorer.controller;

import spark.Request;
import triplestoreexplorer.model.ViewModel;

/**
 * Created by raymondelooff on 29-11-15.
 */
public class DatasetsAddViewController extends ViewController {

    /**
     * The default constructor for the add datasets webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public DatasetsAddViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    /**
     * Called on page load, use this method to set up the data array that needs to be passed to the template
     *
     * @param request
     */
    @Override
    public void dispatch(Request request) {
        setTitle("Add dataset");
    }

}
