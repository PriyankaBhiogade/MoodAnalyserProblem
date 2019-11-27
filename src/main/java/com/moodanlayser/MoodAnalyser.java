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
                throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,"please Enter Proper Mood");
            if (message.contains("Sad"))
                return "SAD";
            else
                return "HAPPY";
        } catch (NullPointerException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"please Enter Proper Mood");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MoodAnalyser)
            return true;
        return false;
    }
}
