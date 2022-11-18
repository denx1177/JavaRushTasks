package com.javarush.task.pro.task04.task0415;

import java.util.Scanner;

/* 
Площадь круга
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double radius = console.nextDouble();
        double pi = 3.14;
        int s = (int)(pi * radius * radius);
        System.out.println(s);
    }
}