package com.moodanlayser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    MoodAnalyser moodAnalyser = new MoodAnalyser();

    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() {
        String mood = moodAnalyser.analyserMood("I Am In Sad Mood");
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenAnyMood_ShouldReturnHappy() {
        String mood = moodAnalyser.analyserMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",mood);
    }
}
