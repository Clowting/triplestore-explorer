package triplestoreexplorer.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import spark.Request;
import triplestoreexplorer.formatter.Formatter;
import triplestoreexplorer.model.ViewModel;

import java.io.*;
import java.net.URL;


/**
 * This is the controller for the datasets webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DatasetsViewController extends ViewController {

    /**
     * The default constructor for the datasets webpage
     * @param model The model used for the webpage
     */
    public DatasetsViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    @Override
    public void dispatch(Request request) {
        // Set title
        setTitle("View datasets");

        // Get datasets from Fuseki
        JSONParser jsonParser = new JSONParser();

        try {
            URL oracle = new URL("http://localhost:3030/$/server");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            JSONObject jsonObject = (JSONObject) jsonParser.parse(in);
            JSONObject formattedObject = Formatter.replaceDotInKeysFromJSONObject(jsonObject);

            // Add datasets
            model.addData("datasets", formattedObject.get("datasets"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
