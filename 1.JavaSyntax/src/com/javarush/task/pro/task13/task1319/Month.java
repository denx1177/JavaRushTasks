package com.javarush.task.pro.task13.task1319;

/* 
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month[] getWinterMonths() {
        Month[] result = {DECEMBER, JANUARY, FEBRUARY};
        return result;
    }

    public static Month[] getSpringMonths() {
        Month[] result = {MARCH, APRIL, MAY};
        return result;
    }

    public static Month[] getSummerMonths() {
        Month[] result = {JUNE, JULY, AUGUST};
        return result;
    }

    public static Month[] getAutumnMonths() {
        Month[] result = {SEPTEMBER, OCTOBER, NOVEMBER};
        return result;
    }
}
