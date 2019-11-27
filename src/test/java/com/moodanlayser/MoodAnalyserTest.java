package com.moodanlayser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;

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
        Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
        Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        Assert.assertEquals(new MoodAnalyser(), myObject);
    }

    @Test
    public void givenClassName_whenNoSuchClass_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethod_whenNotProper_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    //UC5
    @Test
    public void givenMoodAnalyseClassWithPara_WhenProper_ReturnObject() throws MoodAnalyserException {
        Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
        Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor,"I am in Happy Mood");
        Assert.assertEquals(new MoodAnalyser("I am in Happy Mood"), myObject);
    }

    @Test
    public void givenClassNameWithPara_whenNoSuchClass_ReturnMoodAnalyserException() {
        MoodAnalyser moodAnalyser = null;
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor,"I am in Happy Mood");
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMethodWithPara_whenNotProper_ReturnMoodAnalyserException() {
//        MoodAnalyser moodAnalyser = null;
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor,"I am in Happy Mood");
        }catch (MoodAnalyserException e){
            Assert.assertEquals(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    //UC6
    @Test
    public void givenMessage_WithReflectionWhenProper_ReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            Object mood = MoodAnalyserReflector.invokeMethod(myObject,"analyserMood");
            Assert.assertEquals("HAPPY",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMessage_WithReflectionWhenImproper_ReturnMoodAnalysisException() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
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
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue (myObject,"message","I am in Happy Mood");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_withReflectorWhenImproperFiled_ReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue (myObject,"message123","I am in Happy Mood");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenHappyMessage_withReflectorWhenFieldIsNull_ReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor );
            MoodAnalyserReflector.setFieldValue (myObject,null,"I am in Happy Mood");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    //RefactorConstructionTest
    @Test
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy() {
        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor();
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor);
            MoodAnalyserReflector.setFieldValue(myObject, "message", "I am in happy mood");
            Object analyseMood = MoodAnalyserReflector.invokeMethod(myObject, "analyzeMood");
            Assert.assertEquals("HAPPY", analyseMood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() {
        try {
            Constructor<?> constructor = MoodAnalyserReflector.getConstructor(String.class);
            Object myObject = MoodAnalyserReflector.creatMoodAnalyser(constructor,"I am in happy mood");
            Assert.assertEquals(new MoodAnalyser("I am in happy mood"),myObject);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
