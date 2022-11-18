package com.javarush.task.pro.task03.task0311;

import java.util.Scanner;

/* 
Высокая точность
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        double numA = console.nextDouble();
        double numB = console.nextDouble();
        System.out.println(Math.abs(numA-numB)<0.000001 ? "числа равны" : "числа не равны");
    }
}
