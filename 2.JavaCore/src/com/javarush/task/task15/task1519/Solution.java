package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
//        input = reader.readLine();
//        while (!"exit".equals(input)) {
//        можно внести чтение из консоли в условие while и тогда отказаться от чтения из консоли в блоке finally
            while (!("exit".equals(input = reader.readLine()))){
            try {
                if (input.contains(".")) {
                    print(Double.valueOf(input));
                } else {
                    int number = Integer.parseInt(input);
                    if (number > 0 && number < 128) {
                        print((short)number);
                    } else print(number);
                }
            } catch (NumberFormatException e) {
                print(input);
            }
//            finally {
//                input = reader.readLine();
//            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
