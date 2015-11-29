package triplestoreexplorer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This model is used for every single webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class ViewModel {

    private String title;
    private Map<String, String> parameters;
    private Map<String, Map> data;

    /**
     * The default constructor
     */
    public ViewModel() {
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
    private Map<String, String> getParameters() {
        return parameters;
    }

    /**
     * Sets the parameters of the request
     * @param parameters The parameters of the request
     */
    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    /**
     * This method returns the data stored in the model
     * @return The data stored in the model
     */
    public Map<String, Map> getData() {
        return data;
    }

}
