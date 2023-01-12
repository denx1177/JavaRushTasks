package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));) {
            fileName1 = console.readLine();
            fileName2 = console.readLine();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
        ) {
            while (br.ready()) {
                String stringLine = br.readLine();
                String replacement = stringLine.replaceAll("\\.","!");
                bw.write(replacement);
            }
        }
    }
}
