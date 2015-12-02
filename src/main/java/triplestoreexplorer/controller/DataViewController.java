package triplestoreexplorer.controller;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONObject;
import spark.Request;
import triplestoreexplorer.formatter.Formatter;
import triplestoreexplorer.model.ViewModel;

/**
 * This is the controller for the browse webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DataViewController extends ViewController {

    /**
     * The default constructor for the browse webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public DataViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    /**
     * Adds request data to the model
     * @param request The request object
     */
    private void addRequestDataToModel(Request request) {
        model.addData("dataset", request.params(":dataset"));
    }

    @Override
    public void dispatch(Request request) {
        setTitle("Browse data");

        // Add request data to model
        addRequestDataToModel(request);

        // Query
        String query = "SELECT*WHERE{?p?s?o}";
        HttpRequest queryRequest = HttpRequest.get("http://localhost:3030/" + request.params(":dataset") + "/query?query=" + query);
        String result = queryRequest.body();

        JSONObject jsonObject = new JSONObject(result);
        jsonObject.getJSONObject("results");

        // Add datasets
        model.addData("result", Formatter.jsonStringToHashMap(jsonObject.getJSONObject("results").toString()));
    }
}