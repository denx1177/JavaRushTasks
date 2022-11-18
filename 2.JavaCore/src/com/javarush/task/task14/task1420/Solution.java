package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
НОД
*/

public class Solution {
    static ArrayList<Integer> dividersList(int number){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        result.add(number);
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer x = 0;
        Integer y = 0;
        Integer result = null;
        try {
            x = Integer.parseInt(in.readLine());
            y = Integer.parseInt(in.readLine());

            List<Integer> listX = dividersList(x);
            List<Integer> listY = dividersList(y);

            List<Integer> listMin, listMax;
            if (listX.get(listX.size()-1) >= listY.get(listY.size()-1)){
                listMax = listX;
                listMin = listY;
            }else {
                listMax = listY;
                listMin = listX;
            }
            for (int i = listMin.size()-1; i >= 0 ; i--) {
                int index = Collections.binarySearch(listMax,listMin.get(i));
//                System.out.println(index);
//                System.out.println(listMin.get(i));
                if (index >= 0){
                    result = listMin.get(i);
                    break;
                }
            }
//            System.out.println(Arrays.toString(listX.toArray()));
//            System.out.println(Arrays.toString(listY.toArray()));
            System.out.println(listX);
            System.out.println(listY);
            System.out.println(result);

        } catch (Exception e) {
//            e.printStackTrace();
        }

    }
}
