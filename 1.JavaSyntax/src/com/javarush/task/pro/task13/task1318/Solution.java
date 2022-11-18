package com.javarush.task.pro.task13.task1318;

/* 
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
        System.out.println(getNextMonth(Month.DECEMBER));
    }

    public static Month getNextMonth(Month month) {
//------------- Эталонное решение
//        int index = month == Month.DECEMBER ? 0 : month.ordinal() + 1;
//------------- Мои решения        
        int index = month.ordinal();
//        if (index == 11){index = 0;} else { index++;}
        index = index == 11 ? 0 : ++index;
        return month.values()[index];
    }
}
