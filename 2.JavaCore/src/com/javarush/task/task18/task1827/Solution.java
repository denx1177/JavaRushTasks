package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0 || !args[0].equals("-c")) {return;}
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        int max = Integer.MIN_VALUE;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String inputString = br.readLine();
                String idString = inputString.substring(0, 8);
                int id = Integer.parseInt(idString.trim());
                max = Math.max(id, max);
            }
            max++;
        }
        StringBuilder outputString = new StringBuilder((String.format(Locale.ENGLISH,
                "%-8d%-30.30s%-8.2f%-4.4s", max, args[1], Double.parseDouble(args[2]), args[3])));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.newLine();
            bw.append(outputString.toString());
        }
    }
}
