package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.Integer.parseInt;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        testString.printSomething();
        System.setOut(console);
        String result = byteArrayOutputStream.toString().replaceAll("[\\p{C}]", "");
        String[] arrayString = result.split(" ");
        int a = parseInt(arrayString[0]);
        int b = parseInt(arrayString[2]);
        Integer c;
        switch (arrayString[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            default:
                c = null;
        }
        result = (a + " " + arrayString[1] + " " + b + " = " + c);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

