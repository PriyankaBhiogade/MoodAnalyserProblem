package com.moodanlayser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser() throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanlayser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor();
            Object moodObject = moodConstructor.newInstance();
            return (MoodAnalyser) moodObject;
        }catch (ClassNotFoundException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,"please Enter Proper Class Name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,"please Enter Proper Method Name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static MoodAnalyser createMoodAnalyser(String message) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanlayser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(message);
            return (MoodAnalyser) moodObject;
        }catch (ClassNotFoundException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS,"please Enter Proper Class Name");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,"please Enter Proper Method Name");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
