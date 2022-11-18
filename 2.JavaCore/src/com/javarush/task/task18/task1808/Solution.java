package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream inputStream1 = new FileInputStream(
                new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream outputStream2 = new FileOutputStream(
                     new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream outputStream3 = new FileOutputStream(
                     new BufferedReader(new InputStreamReader(System.in)).readLine());) {
            int inputLength = inputStream1.available();
            int outputLength2 = inputLength % 2 == 0 ? inputLength/2 : inputLength/2 +1;
            int outputLength3 = inputLength/2;
//            byte[] array2 = inputStream1.readNBytes(outputLength2);
//            readNBytes не принимает валидатор
//            byte[] array3 = inputStream1.readNBytes(outputLength2);
            byte[] array2 = new byte[outputLength2];
            byte[] array3 = new byte[outputLength3];
            inputStream1.read(array2);
            inputStream1.read(array3);
            outputStream2.write(array2);
            outputStream3.write(array3);
//            outputStream2.write(inputStream1.readNBytes(outputLength2));
//            outputStream3.write(inputStream1.readNBytes(outputLength3));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
