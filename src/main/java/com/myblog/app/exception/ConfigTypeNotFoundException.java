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


    /**
     * Constructs a {@code ConfigTypeNotFoundException} for the named type
     * with the specified cause.
     *
     * @param typeName the fully qualified name of the unavailable type
     * @param cause the exception that was thrown when the system attempted to
     *    load the named type, or {@code null} if unavailable or inapplicable
     */
    public ConfigTypeNotFoundException(String typeName, Throwable cause) {
        super("Type " + typeName + " not present", cause);
    }

}
