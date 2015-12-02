package triplestoreexplorer.controller;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONObject;
import spark.Request;
import triplestoreexplorer.formatter.Formatter;
import triplestoreexplorer.helper.Base64Helper;
import triplestoreexplorer.model.ViewModel;

import java.io.UnsupportedEncodingException;

/**
 * This is the controller for the browse webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DataDetailViewController extends ViewController {

    /**
     * The default constructor for the browse webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public DataDetailViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    /**
     * Adds request data to the model
     * @param request The request object
     */
    private void addRequestDataToModel(Request request) {
        model.addData("dataset", request.params(":dataset"));
        model.addData("page", request.params(":page"));
        model.addData("spo", request.params(":spo"));
        model.addData("value", request.params(":value"));
    }

    /**
     * Returns a simple select query based on the SPO and value
     * @param spo Subject, predicate or object
     * @param value The value to look for
     * @return The built query
     */
    private String buildQuery(String spo, String value) {
        return "SELECT * WHERE{ ?p ?s ?o }" +
               "VALUES (?" + spo + ") {" +
                    "(\"" + value + "\")" +
               "}";
    }

    /**
     * Returns the request result of the given dataset, method and query
     * @param dataset The dataset to query
     * @param method The method to use for the query, either 'query' or 'update'
     * @param query The query itself
     * @return The query result
     */
    private String executeQuery(String dataset, String method, String query) {
        String encodedQuery = null;
        try {
            encodedQuery = java.net.URLEncoder.encode(query, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        HttpRequest queryRequest = HttpRequest.get("http://localhost:3030/" + dataset + "/query?" + method + "=" + encodedQuery);

        return queryRequest.body();
    }

    @Override
    public void dispatch(Request request) {
        setTitle("Browse data");

        // Add request data to model
        addRequestDataToModel(request);

        // Query building
        String query = buildQuery(request.params(":spo"), Base64Helper.decode(request.params(":value")));

        // Execute query
        String result = executeQuery(request.params(":dataset"), request.params(":method"), query);

        JSONObject jsonObject = new JSONObject(result);
        jsonObject.getJSONObject("results");

        // Add datasets
        model.addData("result", Formatter.jsonStringToHashMap(jsonObject.getJSONObject("results").toString()));
    }
}