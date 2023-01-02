package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        br.close();
        int hitCounter = 0;
        Pattern ptrn = Pattern.compile("(\\bworld\\b)");
        while (reader.ready()) {
            String line = reader.readLine();
            Matcher matcher = ptrn.matcher(line);
            while (matcher.find()) {
//                System.out.println(String.format("Match: %s at index [%d, %d]",
//                        matcher.group(), matcher.start(), matcher.end()));
                hitCounter += matcher.groupCount();
            }
        }
        reader.close();
        System.out.println(hitCounter);
    }
}
