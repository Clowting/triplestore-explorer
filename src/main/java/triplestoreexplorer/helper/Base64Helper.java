package triplestoreexplorer.helper;


import java.nio.charset.StandardCharsets;

/**
 * A Base64 helper for Handlebars.java
 * @author Raymon de Looff, Thijs Clowting
 */
public abstract class Base64Helper {

    /**
     * Encodes a String to Base64
     * @param stringToEncode The String to be encoded
     * @return The Base64 encoded String
     */
    public static String encode(String stringToEncode) {
        return java.util.Base64.getEncoder().encodeToString(stringToEncode.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Decodes a String to Base64
     * @param stringToDecode The String to be encoded
     * @return The Base64 encoded String
     */
    public static String decode(String stringToDecode) {
        return new String(java.util.Base64.getDecoder().decode(stringToDecode), StandardCharsets.UTF_8);
    }

}
