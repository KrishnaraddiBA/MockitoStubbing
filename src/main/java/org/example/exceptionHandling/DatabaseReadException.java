package org.example.exceptionHandling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(String s) {
        super(s);
    }
}
