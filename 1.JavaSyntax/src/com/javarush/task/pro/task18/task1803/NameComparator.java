package com.javarush.task.pro.task18.task1803;

import java.util.Comparator;

/* 
Наставники JavaRush
*/

public class NameComparator implements Comparator<JavaRushMentor>{
    //напишите тут ваш код
    public int compare(JavaRushMentor obj1, JavaRushMentor obj2){
        return obj1.getName().length() - obj2.getName().length();
    }
}
