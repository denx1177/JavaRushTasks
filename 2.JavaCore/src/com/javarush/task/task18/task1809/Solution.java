package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try (
                FileInputStream inputStream1 = new FileInputStream(br.readLine());
                FileOutputStream outputStream2 = new FileOutputStream(br.readLine())
        ) {
            int inputLength = inputStream1.available();
            byte[] array = new byte[inputLength];
            while (inputStream1.available() > 0) {
                inputStream1.read(array);
            }
            for (int i = inputLength - 1; i >= 0; i--) {
                outputStream2.write(array[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
