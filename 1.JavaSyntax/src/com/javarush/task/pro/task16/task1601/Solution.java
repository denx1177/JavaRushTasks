package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(77, 10, 14);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        String result = "";
        int day = date.getDay();
//        switch (day){
//            case 0: result = "Воскресенье";break;
//            case 1: result = "Понедельник";break;
//            case 2: result = "Вторник";break;
//            case 3: result = "Среда";break;
//            case 4: result = "Четверг";break;
//            case 5: result = "Пятница";break;
//            case 6: result = "Суббота";break;
//        }
        System.out.println(date);
        System.out.println(day);
        switch (day) {
            case 0: return "воскресенье";
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
        }

        return result;
    }
}
