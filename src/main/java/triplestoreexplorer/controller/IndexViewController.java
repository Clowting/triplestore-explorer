package triplestoreexplorer.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import spark.Request;
import triplestoreexplorer.formatter.Formatter;
import triplestoreexplorer.model.ViewModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * This is the controller for the datasets webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class IndexViewController extends ViewController {

    /**
     * The default constructor for the datasets webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public IndexViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    @Override
    public void dispatch(Request request) {
        // Set title
        setTitle("Overview");

        // Get datasets from Fuseki
        JSONParser jsonParser = new JSONParser();

        try {
            URL oracle = new URL("http://localhost:3030/$/server");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            JSONObject jsonObject = (JSONObject) jsonParser.parse(in);
            JSONObject formattedObject = Formatter.replaceDotInKeysFromJSONObject(jsonObject);

            // Add datasets
            model.addData("version", formattedObject.get("version"));
            model.addData("startDateTime", formattedObject.get("startDateTime"));
            model.addData("uptime", formattedObject.get("uptime"));
            model.addData("datasets", formattedObject.get("datasets"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
