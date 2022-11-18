package com.javarush.task.pro.task13.task1303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* 
Выводим в консоли элементы множества
*/

public class Solution {

    public static void print(HashSet<String> words) {
        Iterator<String> it = words.iterator();
        Iterator<String> it2 = words.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println(it.next());
//            if (++i%2 == 0){System.out.println(it2.next());}
        }
//        System.out.println("_________________");
//        System.out.println(it2.next());
//        System.out.println(it2.next());
//        System.out.println(it2.next());
//        System.out.println(it2.next());
//        System.out.println(it2.next());
    }

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(Arrays.asList("Программированию обычно учат на примерах.".split(" ")));
        print(words);
    }
}
