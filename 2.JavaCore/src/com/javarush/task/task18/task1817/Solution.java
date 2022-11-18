package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        int spaceCounter = 0;
        int totalCounter = 0;
        try (FileReader fr = new FileReader(args[0])){
            while (fr.ready()){
                char ch = (char) fr.read();
                totalCounter += 1;
                if (ch == ' ') {
                    spaceCounter += 1;
                }
            }
            double result = Math.round(1.0 * spaceCounter / totalCounter * 10000);
            System.out.println(result/100);
        }
    }
}
