package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[1]);
             FileOutputStream fos = new FileOutputStream(args[2])) {
            byte input;
            if ("-e".equals(args[0])) {
                while(fis.available()>0) {
                    input = (byte) fis.read();
                    fos.write(input - 3);
                }
            }else if ("-d".equals(args[0])){
                while (fis.available()>0) {
                    input = (byte) fis.read();
                    fos.write(input+3);
                }
            }else{
                System.out.println("Invalid parameter");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
