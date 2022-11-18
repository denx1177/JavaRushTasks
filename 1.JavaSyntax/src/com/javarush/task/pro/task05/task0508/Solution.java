package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        strings = new String[6];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = console.nextLine();
        }
        //-----------------------------------------------------------
        for (int i = 0; i < strings.length-1; i++) { //цикл от 0 до предпоследнего элемента
            if (strings[i] == null) {   // если эталонный элемент == null
                continue;               // то сразу заканчиваем эту итерацию и переходим к следующему эталону
            }
            boolean matchFlag = false;  //сбрасываем флаг совпадения эталона и кандидата
            for (int j = i + 1; j < strings.length; j++) { // цикл по элементам от следующего за эталонным до последнего
                if (strings[j] == null) {   //если элемент кандидат == null
                    continue;               // то сразу заканчиваем эту итерацию и переходим к следующему кандидату
                }
                if (strings[i].equals(strings[j])) {    //если кандидат эквивалентен эталону
                    strings[j] = null;                  //то удаляем значение кандидата из массива
                    matchFlag = true;                   //устанавливаем флаг совпадения эталона и кандидата
                }
            }
            strings[i] = matchFlag ? null : strings[i]; //в случае установленного флага совпадения
                                                        //удаляем значение эталона из массива
        }
        //------------------------------------------------------------
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}
