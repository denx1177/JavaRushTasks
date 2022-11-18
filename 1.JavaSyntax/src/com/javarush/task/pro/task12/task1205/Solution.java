package com.javarush.task.pro.task12.task1205;

/* 
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        Double res = a / b;
        System.out.println(res);
        System.out.println(Double.POSITIVE_INFINITY);
//        if (res.isInfinite(res)) {
//            System.out.println(res > 0 ? "Double.POSITIVE_INFINITY" : "Double.NEGATIVE_INFINITY");
//        } else if (res.isNaN(res))
//        {
//            System.out.println("Double.NaN");
//        } else {
//            System.out.println(res);
//        }

    }
}
