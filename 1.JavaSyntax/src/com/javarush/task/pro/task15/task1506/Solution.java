package com.javarush.task.pro.task15.task1506;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* 
Фейсконтроль
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> strList = Files.readAllLines(Paths.get(scanner.nextLine()));
            for (int i = 0; i < strList.size(); i++) {
                String str = strList.get(i);
                str = str.replaceAll("[., ]", "");
                strList.set(i, str);
                System.out.println(str);
            }
//            System.out.println(strList);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }

    }
}

