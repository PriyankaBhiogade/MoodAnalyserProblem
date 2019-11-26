package com.moodanlayser;

public class MoodAnalyser {

    public String analyserMood(String message) {
        if(message.contains("SAD"))
            return "SAD";
        return "HAPPY";
    }
}
