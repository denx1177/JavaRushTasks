package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        String fileName = "";
        while (!exit) {
            fileName = br.readLine();
            try (FileInputStream fis = new FileInputStream(fileName)) {

            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                exit = true;
            }
        }
    }
}
