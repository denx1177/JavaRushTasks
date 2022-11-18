package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            int count = 0;
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (data == 44) {
                    count++;
                }
            }
            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
