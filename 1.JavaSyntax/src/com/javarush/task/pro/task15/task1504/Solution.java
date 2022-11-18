package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             var inputStream = Files.newInputStream(Paths.get(scanner.nextLine()));
             var outputStream = Files.newOutputStream(Paths.get(scanner.nextLine()))
        ) {
            byte[] buffer = new byte[1024];
            while (inputStream.available() > 0) {
                int read = inputStream.read(buffer);
                for (int i = 0; i < read; i += 2) {
                    if (i < read - 1) {
                        byte tmp = buffer[i];
                        buffer[i] = buffer[i + 1];
                        buffer[i + 1] = tmp;
                    }
                }


                outputStream.write(buffer, 0, read);
            }
            // ****Правильное решение
            /*
            byte[] bytesIn = inputStream.readAllBytes();
            byte[] bytesOut = new byte[bytesIn.length];
            for (int i = 0; i < bytesIn.length; i += 2) {
                if (i < bytesIn.length - 1) {
                    bytesOut[i] = bytesIn[i + 1];
                    bytesOut[i + 1] = bytesIn[i];
                } else {
                    bytesOut[i] = bytesIn[i];
                }
            }*/
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }

    }
}

