package com.javarush.task.pro.task04.task0405;

/* 
Незаполненный прямоугольник
*/

public class Solution {
    public static void main(String[] args) {
        int height = 0;
        while (height < 10) {
            int width = 0;
            while (width < 20) {
                System.out.print((width % 19 == 0) || (height % 9 == 0) ? "Б" : " ");
                width++;
            }
            height++;
            System.out.println();
        }

    }
}