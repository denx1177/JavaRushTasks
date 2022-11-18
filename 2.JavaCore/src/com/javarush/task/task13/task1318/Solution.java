package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        Scanner console = new Scanner(System.in);
        String fileName = console.nextLine();
        // тут конструкция простая читаем побайтно из файла в поток FileInputStream
        FileInputStream input = new FileInputStream(fileName);
        // после из этого потока байтов читаем по два байта в поток InputStreamReader
        InputStreamReader reader = new InputStreamReader(input);
//из символьного потока читаем символы в BufferedReader который выступает буфером большого (не знаю размер) куска данных
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (bufferedReader.ready()) {
            // можно читать посимвольно, т.к. BufferedReader наследник Reader и имеет метод read()
//            int data = bufferedReader.read();
//            System.out.print((char)data);
            // а можно читать данные построчно, т.к. у BufferedReader появляется метод readLine()
            String line = bufferedReader.readLine();
            System.out.println(line);
        }
        bufferedReader.close();
        input.close();
    }
}