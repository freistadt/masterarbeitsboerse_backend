package com.masterarbeitsboerse.masterarbeitsboerse.exception;

//simple exception class --> pass the message an call the custructor of the normal Runtime Exception
public class NoResultExecption extends RuntimeException{
    public NoResultExecption(String message) {
        super(message);
    }
}
