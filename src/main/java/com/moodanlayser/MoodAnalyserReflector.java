package com.moodanlayser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
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

    public static Object invokeMethod(Object moodAnalyserObject,String methodName) throws  MoodAnalyserException {
        try {
            return moodAnalyserObject.getClass().getMethod(methodName).invoke(moodAnalyserObject);
        }catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD,
                                                "Define Proper method Name");
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.No_ACCESS,e.getMessage());
        } catch ( InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.METHOD_INVOCATION_ISSUE,
                                            "May be issue with Data entered");
        }
    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalyserException {
        try {
            Field field = myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_FIELD,
                    "Define proper Field Name");
        }catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.No_ACCESS,e.getMessage());
        }
    }
}
