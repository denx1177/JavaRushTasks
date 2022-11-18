package com.javarush.task.pro.task04.task0417;

import java.util.Scanner;

/* 
Скорость ветра
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double vMs = console.nextInt();
        System.out.println(Math.round(vMs*3.6));

    }
}