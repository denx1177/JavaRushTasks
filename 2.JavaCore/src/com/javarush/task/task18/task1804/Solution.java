package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> arrayList = new ArrayList<>(Collections.nCopies(256, 0));
        try (FileInputStream inputStream = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())) {

            while (inputStream.available() > 0) {
                int data = inputStream.read();
                arrayList.set(data, arrayList.get(data)+1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int min = Integer.MAX_VALUE;
        for (Integer element : arrayList) {
            if (element > 0 && element < min){
                min = element;
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == min && arrayList.get(i) != 0){
                System.out.print(i + " ");
            }
        }
    }
}
