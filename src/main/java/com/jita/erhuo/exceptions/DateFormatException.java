package com.jita.erhuo.exceptions;

/**
 * Created by guitar on 15/1/26.
 */
public class DateFormatException extends Exception{

    public DateFormatException(String message){
        super(message);
    }

    public DateFormatException(String message, Throwable cause) {
        super(message,cause);
    }
}
