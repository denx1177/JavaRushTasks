package com.javarush.task.pro.task09.task0908;

/*
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    final private static String BINTOHEX  = "0000x0_0001x1_0010x2_0011x3_0100x4_0101x5_0110x6_0111x7_1000x8_1001x9_1010xa_1011xb_1100xc_1101xd_1110xe_1111xf";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        String hexNumber = "";
        if (binaryNumber == null || binaryNumber.length() == 0){
            return hexNumber;
        }

        int addZero = binaryNumber.length() % 4;
        if (addZero > 0) {
            for (int i = 0; i < 4 - addZero; i++) {
                binaryNumber = "0" + binaryNumber;
            }
        }

        for (int i = 0; i < binaryNumber.length(); i=i+4) {
            for (int j = i; j < i + 4; j++) {
                if (binaryNumber.charAt(j) != '0' && binaryNumber.charAt(j) != '1' ) {
                    return "";
                }
            }
            String subString = binaryNumber.substring(i,i+4);
            int index = BINTOHEX.indexOf(subString) + 5;
            hexNumber = hexNumber + BINTOHEX.charAt(index);
        }
        return hexNumber;
    }

    public static String toBinary(String hexNumber) {
        String binNumber = "";
        if (hexNumber == null || hexNumber.length() == 0){
            return binNumber;
        }

        for (int i = 0; i < hexNumber.length(); i++) {
            char c = hexNumber.charAt(i);
            if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8' && c != '9' &&
                    c != 'a' && c != 'b' && c != 'c' && c != 'd' && c != 'e' && c != 'f') {
                return "";
            }
            int index = BINTOHEX.indexOf("x" + c) - 4;
            binNumber = binNumber + BINTOHEX.substring(index,index + 4);
        }
        return binNumber;
    }
}
