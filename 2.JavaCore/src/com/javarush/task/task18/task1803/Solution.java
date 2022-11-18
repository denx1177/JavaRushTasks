package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
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
        int max = Collections.max(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == max){
                System.out.print(i + " ");
            }
        }
    }
}
