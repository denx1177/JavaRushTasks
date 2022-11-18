package com.javarush.task.pro.task17.task1708;

/* 
Минимальное и максимальное
*/

import java.util.Arrays;
import java.util.Collections;

public class MinMaxUtil {
    //напишите тут ваш код
    // Решение задачи из комментов с неизвестным количеством параметров !!!!!!!!!
    // 1-ый вариант!!!
//    public static int min (Integer ... num) {return Collections.min(Arrays.asList(num));}
    // 2-ой вариант!!!
//    public static int min(int... numbers) {
//        int rez = Integer.MAX_VALUE;
//        for (int number : numbers) {
//            rez = Math.min(number, rez);
//        }
//        return rez;
//    }
//    return Collections.min(Arrays.asList(num));}

    public static int min(int a, int b){
        //Мое решение
//        return a<b ? a : b;
        //Образцовое решение
        return Math.min(a, b);
    }
    public static int min(int a, int b, int c){
        //Мое решение
//        int min = Math.min(a,b);
//        return Math.min(min,c);
        //Образцовое решение
        return min(c, min(a, b));
    }
    public static int min(int a, int b, int c, int d){
        //Мое решение
//        int min = Math.min(a,b);
//        min =  Math.min(min,c);
//        return Math.min(min,d);
        //Образцовое решение
        return min(d, min(a, b, c));
    }
    public static int min(int a, int b, int c, int d, int e){
        //Мое решение
//        int min = Math.min(a, b);
//        min = Math.min(min,c);
//        min = Math.min(min,d);
//        return Math.min(min, e);
        //Образцовое решение
        return min(e, min(a, b, c, d));
    }
    public static int max(int a, int b){
        //Мое решение
//        return a>b ? a : b;
        //Образцовое решение
        return Math.max(a, b);
    }
    public static int max(int a, int b,int c){
        //Мое решение
//        int max = Math.max(a,b);
//        return Math.max(max,c);
        //Образцовое решение
        return max(c, max(a, b));
    }
    
    public static int max(int a, int b,int c, int d){
        //Мое решение
//        int max = Math.max(a,b);
//        max =  Math.max(max,c);
//        return Math.max(max,d);
        //Образцовое решение
        return max(d, max(a, b, c));
    }
    public static int max(int a, int b,int c, int d, int e){
        //Мое решение
//        int max = Math.max(a,b);
//        max =  Math.max(max,c);
//        max =  Math.max(max,d);
//        return Math.max(max,e);
        //Образцовое решение
        return max(e, max(a, b, c, d));
    }
}
