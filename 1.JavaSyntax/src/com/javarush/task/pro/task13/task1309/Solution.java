package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Вася", 4d);
        grades.put("Петя", 5d);
        grades.put("Юра", 4d);
        grades.put("Стас", 3d);
        grades.put("Иван", 4.5d);
    }
}
