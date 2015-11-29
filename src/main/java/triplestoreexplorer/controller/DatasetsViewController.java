package triplestoreexplorer.controller;

import triplestoreexplorer.model.ViewModel;


/**
 * This is the controller for the datasets webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DatasetsViewController extends ViewController {

    /**
     * The default constructor for the datasets webpage
     * @param model The model used for the webpage
     */
    public DatasetsViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    @Override
    public void dispatch() {
        setTitle("View datasets");

        System.out.println("Dispatch " + this.getClass());
    }

}
