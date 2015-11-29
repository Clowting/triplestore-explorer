package triplestoreexplorer.controller;

import triplestoreexplorer.model.DatasetsViewModel;
import triplestoreexplorer.model.ViewModel;


/**
 * This is the controller for the datasets webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DatasetsViewController extends ViewController {

    private DatasetsViewModel model;

    /**
     * The default constructor for the datasets webpage
     * @param model The model used for the webpage
     */
    public DatasetsViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    @Override
    protected void dispatch() {

    }

}
