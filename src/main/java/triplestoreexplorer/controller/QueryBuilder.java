package triplestoreexplorer.controller;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

import java.util.HashMap;

/**
 * Created by thijsclowting on 26-11-15.
 */
public class QueryBuilder {

    private String  queryURL;
    private HashMap result;
    private String  select;
    private HashMap where;
    private HashMap values;
    private int     limit;

    public QueryBuilder(String queryURL) {
        this.queryURL = queryURL;
        this.result = new HashMap<String, Object>();
        this.select = "";
        this.where  = new HashMap<String, String>();
        this.values = new HashMap<String, String>();
        this.limit  = 0;
    }

    public void query() {

        QueryExecution queryExecution =
                QueryExecutionFactory.sparqlService(
                    queryURL +  "query",
                    "SELECT * WHERE {?subject ?predicate ?object}"
                );
        ResultSet resultSet = queryExecution.execSelect();
        ResultSetFormatter.outputAsJSON(System.out, resultSet);

        queryExecution.close();
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public void setWhere(HashMap where) {
        this.where = where;
    }

    public void setValues(HashMap values) {
        this.values = values;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
