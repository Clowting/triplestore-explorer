package triplestoreexplorer.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
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

                        array.put(object);
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

    /**
     * Converts a JSON String to a HashMap
     * @param jsonString The JSON String to be converted
     * @return A HashMap with all the JSON data
     */
    public static HashMap<String, Object> jsonStringToHashMap(String jsonString) {

        HashMap<String,Object> result = null;
        try {
            result = new ObjectMapper().readValue(jsonString, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
