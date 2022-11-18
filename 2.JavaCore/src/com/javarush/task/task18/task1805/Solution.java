package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Set<Integer> set = new TreeSet<>();
        try (FileInputStream inputStream = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine())) {

            while (inputStream.available() > 0) {
                set.add(inputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer element : set) {
            System.out.print(element + " ");
        }
    }
}
