package triplestoreexplorer.helper;


import com.github.kevinsawicki.http.HttpRequest;

/**
 * A Base64 helper for Handlebars.java
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class Base64EncodeHelper {

    /**
     * Encodes a String to Base64
     * @param stringToEncode The String to be encoded
     * @return The Base64 encoded String
     */
    public static String encode(String stringToEncode) {
        return HttpRequest.Base64.encode(stringToEncode);
    }

}
