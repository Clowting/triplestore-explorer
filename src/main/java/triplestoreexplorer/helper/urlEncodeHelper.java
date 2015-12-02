package triplestoreexplorer.helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * A extension for Handlebars.java
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class  urlEncodeHelper {

    /**
     * Encodes a URL
     * @param urlComponent The URL to be encoded
     * @return The encoded URL
     */
    public static String encodeURL(String urlComponent) {
        String encodedURL = "";
        try {
            encodedURL = URLEncoder.encode(urlComponent, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedURL;
    }

}
