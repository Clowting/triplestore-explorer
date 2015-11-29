package triplestoreexplorer.controller;

import triplestoreexplorer.model.ViewModel;
import triplestoreexplorer.template.HandlebarsTemplateEngine;

import java.util.Map;

/**
 * This is the default page controller for every webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class ViewController {

    private String viewName;
    private HandlebarsTemplateEngine handlebarsTemplateEngine;
    protected ViewModel model;
    protected QueryBuilder queryBuilder;

    /**
     * The default constructor
     */
    public ViewController(ViewModel model, String viewName) {
        this.viewName = viewName;
        this.model = model;
        this.handlebarsTemplateEngine = new HandlebarsTemplateEngine();
        //queryBuilder = new QueryBuilder();
    }

    /**
     * Returns the name of the view
     * @return The name of the view
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * Sets the name of the view
     * @return The name of the view
     */
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    /**
     * Returns the data of the view
     * @return The data of the view
     */
    public Map getData() {
        return model.getData();
    }

    /**
     * Called on page load, use this method to set up the data array that needs to be passed to the template
     */
    protected abstract void dispatch();

}
