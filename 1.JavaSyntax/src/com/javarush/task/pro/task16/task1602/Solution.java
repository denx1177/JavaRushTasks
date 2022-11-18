package com.javarush.task.pro.task16.task1602;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* 
Подчищаем хвосты
*/

public class Solution {

    public static void main(String[] args) {
        List<Date> dateList = new ArrayList<>();
        dateList.add(new Date(2015, 12, 25, 20, 40));
        dateList.add(new Date("July 20, 1969"));
        dateList.add(new Date(1989, 11, 9));
        dateList.add(new Date("January 1, 2000"));

        System.out.println("before fixes:");
        dateList.forEach(System.out::println);

        fixDate(dateList);

        System.out.println("after fixes:");
        dateList.forEach(System.out::println);
    }

    static void fixDate(List<Date> brokenDates) {
        Date currentDate = new Date();
//        for (int i =0; i< brokenDates.size(); i++) {
//            if(brokenDates.get(i).after(currentDate)){
//                Date tempDate = brokenDates.get(i);
//                tempDate.setMonth(tempDate.getMonth()-1);
//                tempDate.setYear(tempDate.getYear()-1900);
//                brokenDates.set(i,tempDate);
//            }
//        }
        /*Интересное дело верхний вариант валидатор не принял, хотя в условиях задачи нет требования
        разработать решение строго через for:each.
        И даже в решении через for:each НУЖНО!! пользоваться замаскированным итератором, вместо прямого
        обращения к элементам ArrayList через get и set.
        Но к слову сказать, такого метода изменения элементов списка я и не знал.
        * */
        for (Date brokenDate : brokenDates) {
            if (currentDate.before(brokenDate)) {
                int index = brokenDates.indexOf(brokenDate);
                brokenDate.setMonth(brokenDate.getMonth()-1);
                brokenDate.setYear(brokenDate.getYear()-1900);
                brokenDates.set(index,brokenDate);
            }
        }
    }
}
