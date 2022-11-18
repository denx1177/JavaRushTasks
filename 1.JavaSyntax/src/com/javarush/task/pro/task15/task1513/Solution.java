package com.javarush.task.pro.task15.task1513;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Зри в корень
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);){
            String str = scanner.nextLine();
            Path path = Path.of(str);
            Path root = path.getRoot();
            System.out.println(root);
        }
        catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}

