package edu.eci.arsw.parcial.Exceptions;

public class AirportException extends Exception {
    public AirportException(String message) {
        super(message);
    }

    public AirportException(String message, Throwable cause){
        super(message,cause);
    }

}
