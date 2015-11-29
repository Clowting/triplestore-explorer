package triplestoreexplorer.controller;

import spark.ModelAndView;
import spark.Request;
import triplestoreexplorer.model.ViewModel;
import triplestoreexplorer.template.HandlebarsTemplateEngine;

/**
 * This is the default page controller for every webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class ViewController {

    private String templateViewName;
    private HandlebarsTemplateEngine handlebarsTemplateEngine;
    protected ViewModel model;
    protected QueryBuilder queryBuilder;

    /**
     * The default constructor
     */
    public ViewController(ViewModel model, String templateViewName) {
        this.templateViewName = templateViewName;
        this.model = model;
        this.handlebarsTemplateEngine = new HandlebarsTemplateEngine();
        //queryBuilder = new QueryBuilder();
    }

    /**
     * Returns the name of the template view
     * @return The name of the template view
     */
    public String getTemplateViewName() {
        return templateViewName;
    }

    /**
     * Sets the name of the template view
     */
    public void setTemplateViewName(String templateViewName) {
        this.templateViewName = templateViewName;
    }

    /**
     * Returns the title of the view
     * @return The title of the view
     */
    public String getTitle() {
        return model.getTitle();
    }

    /**
     * Sets the title of the view
     * @param title The title of the view
     */
    public void setTitle(String title) {
        model.setTitle(title);
    }

    /**
     * Called on page load, use this method to set up the data array that needs to be passed to the template
     */
    public abstract void dispatch(Request request);

    /**
     * Renders the web page
     * @return The web page
     */
    public ModelAndView render() {
       return new ModelAndView(model.getData(), templateViewName);
    }

}
