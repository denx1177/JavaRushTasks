package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        String[] tmpArray = elements;
        capacity = capacity + capacity / 2;
        elements = new String[capacity];
        for (int i = 0; i < tmpArray.length; i++) {
            elements[i] = tmpArray[i];
        }
    }

//    public String[] getElements() {
//        String[] result = new String[capacity];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = elements[i];
//        }
//        return result;
//    }
}
