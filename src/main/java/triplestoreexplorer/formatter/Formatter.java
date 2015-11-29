package triplestoreexplorer.formatter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Iterator;

/**
 * Class with simple formatting methods
 * @author Raymon de Looff, Thijs Clowting
 */
public class Formatter {

    /**
     * Replaces every dot in every key with an underscore
     * @param jsonObject The JSONObject that needs to be formatted
     * @return The formatted JSONObject
     */
    public static JSONObject replaceDotInKeysFromJSONObject(JSONObject jsonObject) {
        JSONObject formattedObject = new JSONObject();
        Iterator it = jsonObject.keySet().iterator();

        while(it.hasNext()) {
            String key = (String) it.next();
            String newKey = key.replaceAll("\\.+", "_");

            // Get object
            Object object = jsonObject.get(key);

            // Check if object is of type JSONArray
            if (object instanceof JSONArray) {
                JSONArray array = new JSONArray();

                for(Object item: (JSONArray) object) {
                    if(item instanceof JSONObject) {
                        JSONObject jsonObjectItem = (JSONObject) item;
                        object = replaceDotInKeysFromJSONObject(jsonObjectItem);

                        array.add(object);
                    }
                }

                object = array;
            }

            // Add object with the new key
            formattedObject.put(newKey, object);

            // Remove old key
            it.remove();
        }

        return formattedObject;
    }

}
