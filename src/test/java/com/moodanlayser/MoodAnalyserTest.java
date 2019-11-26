package com.moodanlayser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Sad Mood");
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("SAD",mood);
    }

//    @Test
//    public void givenMessage_WhenAnyMood_ShouldReturnHappy() {
//        MoodAnalyser moodAnalyser = new MoodAnalyser();
//        String mood = moodAnalyser.analyserMood("I am in Any Mood");
//        Assert.assertEquals("HAPPY",mood);
//    }


}
