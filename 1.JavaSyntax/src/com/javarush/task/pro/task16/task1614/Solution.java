package com.javarush.task.pro.task16.task1614;

import java.time.Instant;

/* 
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
//        Instant instantMax = Instant.MAX;
//        long longInstantMax = instantMax.getEpochSecond();
//        System.out.println(instantMax);
//        System.out.println(longInstantMax);

        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        //напишите тут ваш код
        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {
        //напишите тут ваш код
        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
    }

        static Instant getMaxFromSecondsAndNanos(){
            //напишите тут ваш код
            return Instant.ofEpochSecond(Instant.MAX.getEpochSecond(), 999_999_999L);
        }
    }

