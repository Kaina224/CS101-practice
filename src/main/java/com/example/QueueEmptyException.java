package com.example;

public class QueueEmptyException extends Exception{
    public QueueEmptyException(String message){
        super(message);
    }
}
