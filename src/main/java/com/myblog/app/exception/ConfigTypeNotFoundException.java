package com.myblog.app.exception;

public class ConfigTypeNotFoundException extends RuntimeException {

    /**
     * Constructs a {@code ConfigTypeNotFoundException} for the named type
     * with the specified cause.
     *
     * @param typeName the fully qualified name of the unavailable type
     */
    public ConfigTypeNotFoundException(String typeName) {
        super("Type " + typeName + " not present");
    }

}
