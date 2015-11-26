package triplestoreexplorer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This model is used for every single webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class PageModel {

    private String title;
    private Map<String, String> parameters;

    /**
     * The default constructor
     */
    public PageModel() {
        parameters = new HashMap<String, String>();
    }

    /**
     * Returns the title of the webpage
     * @return The title of the webpage
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the webpage
     * @param title The title of the webpage
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the parameters of the request
     * @return The parameters of the request
     */
    public Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters of the request
     * @param parameters The parameters of the request
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
