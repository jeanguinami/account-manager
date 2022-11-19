package com.jean.accountmanager.commons.errors.response;

public class DefaultErrorMessage {
    private DefaultErrorMessage() {
        throw new IllegalStateException("Utility class");
    }

    public static final String INVALID_FIELD = "The field is required or is in an invalid format.";
}
