package triplestoreexplorer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This model is used for every single webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class ViewModel {

    private Map<String, Object> data;

    /**
     * The default constructor
     */
    public ViewModel() {
        data = new HashMap<String, Object>();
    }

    /**
     * Returns the title of the view
     * @return The title of the view
     */
    public String getTitle() {
        return (String) data.get("title");
    }

    /**
     * Sets the title of the view
     * @param title The title of the view
     */
    public void setTitle(String title) {
        data.put("title", title);
    }

    /**
     * Returns the data stored in the model
     * @return The data stored in the model
     */
    public Map<String, Object> getData() {
        return data;
    }

    /**
     * Sets the data in the model
     * @param data The data to set in the model
     */
    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    /**
     * Adds the given map to the data in the model
     * @param key The key to the value
     * @param object The object to store in the model
     */
    public void addData(String key, Object object) {
        data.put(key, object);
    }

}
