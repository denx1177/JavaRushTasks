package com.javarush.task.pro.task12.task1219;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Двойные фигурные скобки
*/

public class Solution {

    public static void main(String[] args) {
//        var strings = new ArrayList<String>(Arrays.asList("Так","тоже","можно","делать","!"));
        var strings = new ArrayList<String>()
        {{
            add("Так");
            add("тоже");
            add("можно");
            add("делать");
            add("!");
        }};
//        System.out.println(Arrays.toString(strings.toArray()));

    }
}
