package com.javarush.task.task12.task1207;

/* 
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
    print(1);
//    print((Integer.valueOf(2)));
    print((Integer)2);
    }

    //Напишите тут ваши методы
    public static void print (int i){
        System.out.println(i);
    }
    public static void print (Integer i){
        System.out.println(i);
    }
}
