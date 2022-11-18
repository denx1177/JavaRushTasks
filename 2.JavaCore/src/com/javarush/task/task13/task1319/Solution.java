package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileWriter writer = new FileWriter(fileName);
        BufferedWriter bufferWriter = new BufferedWriter(writer);

        boolean exit = false;

        while (!exit) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                exit = true;
            }
            bufferWriter.write(line);
            bufferWriter.newLine();
        }
        bufferWriter.close();
    }
}
