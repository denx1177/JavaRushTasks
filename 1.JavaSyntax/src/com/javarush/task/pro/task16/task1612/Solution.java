package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        Set dateTimeSet = new HashSet<LocalDateTime>();
        for (var keyDate:sourceMap.keySet()) {
//            List<LocalTime> timeList = sourceMap.get(keyDate);
//            for (var time : timeList) {
            /*Две строчки выше сокращены до одной строчки ниже*/
            for (var time : sourceMap.get(keyDate)) {
                dateTimeSet.add(LocalDateTime.of(keyDate,time));
            }
        }

        return dateTimeSet;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}