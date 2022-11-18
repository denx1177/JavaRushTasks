package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int engSymbols = 0;
        try (FileReader fr = new FileReader(args[0])){
            while (fr.ready()){
                int data = fr.read();
//                if (data >= 65 && data <= 122 && Character.isAlphabetic(data)){
//                    engSymbols += 1;
//                }
                char ch = (char) data;
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    engSymbols += 1;
                }
//                if (alphabet.contains(String.valueOf(ch))){
//                    engSymbols += 1;
//                }
            }
            System.out.println(engSymbols);
        }
    }
}
