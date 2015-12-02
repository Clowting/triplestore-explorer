package triplestoreexplorer.controller;

import com.github.kevinsawicki.http.HttpRequest;
import org.json.JSONObject;
import spark.Request;
import triplestoreexplorer.formatter.Formatter;
import triplestoreexplorer.model.ViewModel;


/**
 * This is the controller for the datasets webpage
 * @author Raymon de Looff, Thijs Clowting
 */
public class DatasetsViewController extends ViewController {

    /**
     * The default constructor for the datasets webpage
     * @param model The model used for the webpage
     * @param viewName The name of the template view
     */
    public DatasetsViewController(ViewModel model, String viewName) {
        super(model, viewName);
    }

    @Override
    public void dispatch(Request request) {
        // Set title
        setTitle("View datasets");

        HttpRequest getRequest = HttpRequest.get("http://localhost:3030/$/server");
        JSONObject jsonObject = new JSONObject(getRequest.body());
        JSONObject formattedObject = Formatter.replaceDotInKeysFromJSONObject(jsonObject);

        // Add datasets
        model.addData("datasets", formattedObject.get("datasets"));
    }

}
