package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1977,10,14);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
//        System.out.println(dayOfWeek);
//        System.out.println(calendar.getTime());
//        switch(dayOfWeek){
//            case 1:return "Воскресенье";
//            case 2:return "Понедельник";
//            case 3:return "Вторник";
//            case 4:return "Среда";
//            case 5:return "Четверг";
//            case 6:return "Пятница";
//            case 7:return "Суббота";
//
//        }
/*Можно использовать константы класса Calendar имеющие тип int*/
        switch(dayOfWeek){
            case Calendar.SUNDAY:return "Воскресенье";
            case Calendar.MONDAY:return "Понедельник";
            case Calendar.TUESDAY:return "Вторник";
            case Calendar.WEDNESDAY:return "Среда";
            case Calendar.THURSDAY:return "Четверг";
            case Calendar.FRIDAY:return "Пятница";
            case Calendar.SATURDAY:return "Суббота";

        }

        return null;
    }
}
