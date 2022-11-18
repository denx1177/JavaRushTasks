package com.javarush.task.task18.task1802;

import java.io.*;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) /*throws Exception*/ {
        String fileName = null;
        try {
            fileName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int min = Integer.MAX_VALUE;
        try {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                if (data < min) {
                    min = data;
                }
            }
            System.out.print(min);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
