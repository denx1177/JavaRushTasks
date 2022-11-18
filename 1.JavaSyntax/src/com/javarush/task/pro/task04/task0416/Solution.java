package com.javarush.task.pro.task04.task0416;

import java.util.Scanner;

/* 
Share a Coke
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int canOfCola = console.nextInt();
        int people = console.nextInt();
        System.out.println(1.0 * canOfCola / people);

    }
}