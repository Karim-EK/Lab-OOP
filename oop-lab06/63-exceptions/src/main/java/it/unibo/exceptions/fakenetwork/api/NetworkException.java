package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException {

    private static final String SENDING_ERROR = "Network error while sending message: ";

    @SuppressWarnings("unused")
    private String message;

    public NetworkException(String message) {
        super(SENDING_ERROR + message);
    }

    public NetworkException() {
        this("unknown");
    }
}

