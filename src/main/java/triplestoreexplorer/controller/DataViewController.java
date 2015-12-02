package triplestoreexplorer.controller;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.Query;
import spark.Request;
import triplestoreexplorer.model.ViewModel;

/**
 * Created by thijsclowting on 02-12-15.
 */
public class DataViewController extends ViewController {


    /**
     * The default constructor
     *
     * @param model
     * @param templateViewName
     */
    public DataViewController(ViewModel model, String templateViewName) {
        super(model, templateViewName);
    }

    @Override
    public void dispatch(Request request) {
        setTitle("Data overview");

        // Query building
        SelectBuilder sb = new SelectBuilder()
                .addVar( "*" )
                .addWhere( "?s", "?p", "?o" );

        Query q = sb.build();

    }
}
