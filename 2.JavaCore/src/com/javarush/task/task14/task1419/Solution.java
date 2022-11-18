package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception

        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            throw new NumberFormatException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NoSuchFieldException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ClassCastException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
//            throw new IllegalCallerException(); // не поддерживается jdk 1.8.0_321
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
