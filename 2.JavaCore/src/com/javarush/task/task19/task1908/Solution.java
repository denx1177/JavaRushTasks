package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        try (BufferedReader br = new BufferedReader(new FileReader(filename1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(filename2))
        ) {
            Pattern ptrn = Pattern.compile("\\b(\\d+)\\b");
            while (br.ready()) {
                String line = br.readLine();
                Matcher matcher = ptrn.matcher(line);
                while (matcher.find()) {
                    bw.write(matcher.group() + " ");
                }
            }
        }
    }
}
