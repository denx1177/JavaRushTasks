package com.javarush.task.pro.task03.task0312;

import java.util.Scanner;

/* 
Сравним строки
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str1 = console.nextLine();
        String str2 = console.nextLine();
        System.out.println(str1.equals(str2) ? "строки одинаковые" : "строки разные");

    }
}
