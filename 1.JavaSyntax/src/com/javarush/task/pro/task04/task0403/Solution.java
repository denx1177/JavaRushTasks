package com.javarush.task.pro.task04.task0403;

import java.util.Scanner;

/* 
Суммирование
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int sum = 0;
        int intNumber = 0;
        boolean isEnter = false;
        while (!isEnter){
            while (console.hasNextInt()){
                intNumber = console.nextInt();
                sum = sum + intNumber;
            }
            isEnter = console.nextLine().equals("ENTER") ? true : false;
        }
        System.out.println(sum);
    }
}