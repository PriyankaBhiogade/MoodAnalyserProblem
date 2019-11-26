package com.moodanlayser;

public class MoodAnalyserException extends Exception {

    enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY,NO_SUCH_CLASS
    }

    ExceptionType type;
    public MoodAnalyserException( ExceptionType type,String message) {
        super(message);
        this.type = type;
    }
}
