package com.moodanlayser;

public class MoodAnalyser {
    private String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyserMood() throws MoodAnalyserException {
        try {
            if(message.length() == 0)
                throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"Please Enter Proper Mood");
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"Please Enter Proper Mood");
        }
    }
}
