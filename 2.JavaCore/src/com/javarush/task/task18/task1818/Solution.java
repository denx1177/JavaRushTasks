package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (FileWriter writer1 = new FileWriter(reader.readLine());
             FileReader reader2 = new FileReader(reader.readLine());
             FileReader reader3 = new FileReader(reader.readLine())) {
            while (reader2.ready()) {
                writer1.write(reader2.read());
            }
            while (reader3.ready()) {
                writer1.write(reader3.read());
            }
        }
    }
}
