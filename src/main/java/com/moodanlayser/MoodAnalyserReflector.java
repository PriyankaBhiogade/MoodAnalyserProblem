package com.moodanlayser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
    public static Constructor<?> getConstructor(Class<?>... param) throws MoodAnalyserException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanlayser.MoodAnalyser");
            return moodAnalyserClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_CLASS, "Class Not Found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_SUCH_METHOD, "Method Not Found");
        }
    }

    public static Object creatMoodAnalyser(Constructor<?> constructor, Object ... message ) throws MoodAnalyserException {
        try {
            return constructor.newInstance(message);
        } catch (IllegalAccessException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.NO_ACCESS, "Method Not Found");
        } catch (InstantiationException | InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionType.OBJECT_CREATION_ISSUE, "Method Not Found");
        }
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
        }catch (NullPointerException e){
            throw new  MoodAnalyserException(MoodAnalyserException.ExceptionType.ENTERED_NULL,"please Enter Proper Field");
        }
    }

}
