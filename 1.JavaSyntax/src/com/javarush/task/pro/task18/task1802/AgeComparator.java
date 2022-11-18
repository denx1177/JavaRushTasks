package com.javarush.task.pro.task18.task1802;

import java.util.Comparator;

/* 
Сортировка по возрасту
*/

public class AgeComparator implements Comparator<Student> {
    //напишите тут ваш код
    public int compare (Student obj1, Student obj2){

        return obj2.getAge()- obj1.getAge();
    }
}
