package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int minNext = min;
//Допустим, что наша программа уже работает правильно, и у нас есть промежуточный результат с двумя разными значениями
// min и minNext. В случае ввода нового числа x могут возникнуть следующие варианты:
        //1. x больше либо равно minNext = ничего не делать (null action)
        //2. x больше min и меньше minNext = minNext получает новое значение (minNext = x)
        //3. x равно min = ничего не делать (null action)
        //4. x меньше min = minNext получает новое значение = min, и после min получает новое значение = x
        while (console.hasNextInt()) { // Цикл (пока введённое число является целым)
            int x = console.nextInt();
            if (x < min) { //проверка, что введенное число меньше минимального
                minNext = min; // в этом случае старое минимальное сохраняем во второе минимальное
                min = x; // и введённое число становится новым минимальным
            } else if (x > min && x < minNext) { //иначе проверяем что введенное число строго больше минимального
                                                // и одновременно строго меньше второго минимального
                minNext = x; //в этом случае введённое число становится новым вторым минимальным
            }
        }

        System.out.println(minNext); //Вывод результата

    }
}