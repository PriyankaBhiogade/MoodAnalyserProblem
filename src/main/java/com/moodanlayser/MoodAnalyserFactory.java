package com.moodanlayser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyser(String m){
        try {
            Class<?>moodAnalyserClass = Class.forName("com.moodanlayser.MoodAnalyser");
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodObject = moodConstructor.newInstance(m);
            return (MoodAnalyser) moodObject;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
