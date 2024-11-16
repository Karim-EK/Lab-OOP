package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;

public class NetworkException extends IOException {

    private static final String SENDING_ERROR = "Network error while sending message: ";

<<<<<<< HEAD
    @SuppressWarnings("unused")
    private String message;

=======
>>>>>>> cad967d33059882af678708569ecd6aea47ffd76
    public NetworkException(String message) {
        super(SENDING_ERROR + message);
    }

    public NetworkException() {
        this("unknown");
    }
}

