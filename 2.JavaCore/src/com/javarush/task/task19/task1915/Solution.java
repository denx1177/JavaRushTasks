package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String filename;
        PrintStream consoleOut = System.out;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {
            filename = console.readLine();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        
        testString.printSomething();
        System.setOut(consoleOut);
        
        try (FileOutputStream fileStream = new FileOutputStream(filename)) {
            fileStream.write(byteArrayOutputStream.toByteArray());
        }
        System.out.println(byteArrayOutputStream);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

