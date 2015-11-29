package triplestoreexplorer.model;

import java.util.HashMap;
import java.util.Map;

/**
 * This model is used for every single webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class ViewModel {

    private Map<String, Map> data;

    /**
     * The default constructor
     */
    public ViewModel() {
        data = new HashMap<String, Map>();

        // Add view data
        HashMap<String, String> viewData = new HashMap<String, String>();
        data.put("view", viewData);
    }

    /**
     * Returns the title of the view
     * @return The title of the view
     */
    public String getTitle() {
        return (String) data.get("view").get("title");
    }

    /**
     * Sets the title of the view
     * @param title The title of the view
     */
    public void setTitle(String title) {
        data.get("view").put("title", title);
    }

    /**
     * Returns the data stored in the model
     * @return The data stored in the model
     */
    public Map<String, Map> getData() {
        return data;
    }

    /**
     * Sets the data in the model
     * @param data The data to set in the model
     */
    public void setData(Map<String, Map> data) {
        this.data = data;
    }

    /**
     * Adds the given map to the data in the model
     * @param key The key to the value
     * @param map The Map to store in the model
     */
    public void addData(String key, Map map) {
        data.put(key, map);
    }

}
