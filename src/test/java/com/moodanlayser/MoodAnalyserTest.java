package com.moodanlayser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyserTest {

    //UC1
    @Test
    public void givenMessage_WhenSad_ShouldReturnSad() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I Am In Sad Mood");
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("SAD",mood);
    }

    @Test
    public void givenMessage_WhenAnyMood_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("HAPPY",mood);
    }

    //UC2
    @Test
    public void givenNull_WhenProper_ShouldReturnHappy() throws MoodAnalyserException {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        String mood = moodAnalyser.analyserMood();
        Assert.assertEquals("HAPPY",mood);
    }

    //UC3
    @Test
    public void givenNull_WhenNullWithCustomException_ShouldReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(MoodAnalyserException.class);
            moodAnalyser.analyserMood();
        }catch (MoodAnalyserException e){
            Assert.assertEquals("please Enter proper Mood",e.getMessage());
        }
    }

    @Test
    public void givenEmpty_WhenENTERED_EMPTY_ShouldReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
             moodAnalyser.analyserMood();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }

    //UC4
    @Test
    public void givenMoodAnalyseClass_WhenProper_ReturnObject() throws MoodAnalyserException {
        MoodAnalyser MoodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        Assert.assertEquals(new MoodAnalyser(), MoodAnalyser);
    }

    @Test
    public void givenClassName_whenNoSuchClass_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            MoodAnalyser MoodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethod_whenNotProper_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
                moodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    //UC5
    @Test
    public void givenMoodAnalyseClassWithPara_WhenProper_ReturnObject() throws MoodAnalyserException {
        MoodAnalyser MoodAnalyser = MoodAnalyserReflector.createMoodAnalyser();
        Assert.assertEquals(new MoodAnalyser("I am in Happy Mood"), MoodAnalyser);
    }

    @Test
    public void givenClassNameWithPara_whenNoSuchClass_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            MoodAnalyser MoodAnalyser = MoodAnalyserReflector.createMoodAnalyser("I am in Happy Mood");
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodWithPara_whenNotProper_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            moodAnalyser = MoodAnalyserReflector.createMoodAnalyser("I am in Happy Mood");
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    //UC6
    @Test
    public void givenMessage_WithReflectionWhenProper_ReturnHappy() {
        try {
            MoodAnalyser myObject = MoodAnalyserReflector.createMoodAnalyser("I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyserMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_WithReflectionWhenImproper_ReturnMoodAnalysisException() {
        try {
            MoodAnalyser myObject = MoodAnalyserReflector.createMoodAnalyser("I am in Happy Mood");
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyserMood1234");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    //UC7
    @Test
    public void givenHappyMessage_withReflectorChangeMoodDynamically_ReturnHappy() {
        try {
            Object myObject = MoodAnalyserReflector.createMoodAnalyser("");
            MoodAnalyserReflector.setFieldValue (myObject,"message","I am in Happy Mood");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
