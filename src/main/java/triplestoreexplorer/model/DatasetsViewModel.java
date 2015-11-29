package triplestoreexplorer.model;

import org.apache.jena.query.ResultSet;

/**
 * This model is used for the datasets overview
 * @author Raymon de Looff, Thijs Clowting
 */
public class DatasetsViewModel extends ViewModel {

    private ResultSet datasets;

    /**
     * The default constructor
     */
    public DatasetsViewModel() {
        super();

        // Set page title
        super.setTitle("Datasets");
    }

    /**
     * This method returns the stored datasets in the model
     * @return The stored datasets
     */
    private ResultSet getDatasets() {
        return datasets;
    }

    /**
     * This method sets the datasets in the model
     * @param datasets The datasets returned from the query
     */
    public void setDatasets(ResultSet datasets) {
        this.datasets = datasets;
    }

}
