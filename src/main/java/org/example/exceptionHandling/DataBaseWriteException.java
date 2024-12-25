package org.example.exceptionHandling;

public class DataBaseWriteException extends RuntimeException{
    String msg;
    DataBaseWriteException(String msg){
        super(msg);
    }
}
