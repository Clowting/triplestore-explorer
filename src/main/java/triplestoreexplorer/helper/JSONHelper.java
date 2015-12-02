package triplestoreexplorer.helper;

import org.json.JSONObject;

/**
 * Simple helper class for JSON objects in the template
 */
public abstract class JSONHelper {

    /**
     * This method returns the value for the given key from the given object
     * @param object The object to use
     * @param key The key to find the value for
     * @return The value corresponding to the key
     */
    public static String getValue(JSONObject object, String key) {
        return object.get(key).toString();
    }

}
