package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;
import java.util.Objects;

/* 
Дефрагментация памяти
*/

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, null, null, "object32", null,null, null,  "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        int nearUnchecked = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == null) {
                nearUnchecked = nearUnchecked > i + 1 ? nearUnchecked : i + 1;
                for (int j = nearUnchecked; j < array.length; j++) {
                    if (array[j] != null) {
                        array[i] = array[j];
                        nearUnchecked = j + 1;
                        array[j] = null;

                        break;
                    }
                }
                if (nearUnchecked == array.length) {
                    break;
                }
            }
        }
    }
}
