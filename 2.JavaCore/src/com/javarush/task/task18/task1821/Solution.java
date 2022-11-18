package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arrayList = new ArrayList<>(Collections.nCopies(256, 0));
        try (FileReader fr = new FileReader(args[0])) {

            while (fr.ready()) {
                int ch = fr.read();
                arrayList.set(ch, arrayList.get(ch)+1);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != 0 ){
                System.out.println((char)i + " " + arrayList.get(i));
            }
        }
    }
}
