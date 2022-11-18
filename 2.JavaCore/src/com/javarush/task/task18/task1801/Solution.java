package com.javarush.task.task18.task1801;

import java.io.*;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            int max = Integer.MIN_VALUE;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (data > max) {
                    max = data;
                }
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
