package com.javarush.task.pro.task09.task0906;

import java.util.regex.Pattern;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber <= 0){
            return binaryNumber;
        }
        while(decimalNumber > 0) {
            binaryNumber = decimalNumber % 2 + binaryNumber;
            decimalNumber = decimalNumber / 2;
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        int decimalNumber = 0;
        if (binaryNumber == null || binaryNumber.length() == 0){
            return decimalNumber;
        }
        int strLength = binaryNumber.length();
        for (int i = 0; i < strLength; i++) {
            int index= strLength-1-i;
//            decimalNumber += Integer.valueOf(binaryNumber.substring(index,index+1)) * Math.pow(2,i);
            decimalNumber += Character.getNumericValue(binaryNumber.charAt(index)) * Math.pow(2,i);
        }
        return decimalNumber;
    }
}
