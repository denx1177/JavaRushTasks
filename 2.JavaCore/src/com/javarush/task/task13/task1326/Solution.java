package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream input = new FileInputStream(fileName);
        InputStreamReader inputReader = new InputStreamReader(input);
        BufferedReader buffer = new BufferedReader(inputReader);

        List<Integer> list = new ArrayList<>();
        while (buffer.ready()) {
            String str = buffer.readLine();
            int i = Integer.parseInt(str);
            if (i%2 == 0 ){
                list.add(i);
            }
        }
        buffer.close();
        // Для сортировки можно воспользоваться методом утилитного класса Collections.sort(list)
//        Collections.sort(list);
        // который на самом деле вызывает метод list.sort(null); поэтому воспользуемся им напрямую:
        list.sort(null); // в качестве компаратора - null, в таком случае сортировка от меньшего к большему
        // если нужна обратная сортировка, то нужно прописывать компаратор явно:
//        list.sort((x,y) -> y-x);
        // Компаратор можно записать лямбдой или с помощью метода утилитного класса Comparator.comparingInt(x -> x)
//        list.sort(Comparator.comparingInt(x -> x));
        // Можно выполнить сортировку преобразовав список в массив, отсортировав массив и записав его обратно в список.
        // что на самом деле и выполняется в реализации метода list.sort()...
//        Integer[] ints = new Integer[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ints[i]= list.get(i);
//        }
//        Arrays.sort(ints);
//        list = Arrays.asList(ints);

        list.forEach(System.out::println);

    }
}
