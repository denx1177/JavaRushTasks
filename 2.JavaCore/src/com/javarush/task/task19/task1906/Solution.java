package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(filename1);
        FileWriter fileWriter = new FileWriter(filename2);
        boolean odd = false;
        while (fileReader.ready()){
            int data = fileReader.read();
            if (odd){
                fileWriter.write(data);
                odd = false;
            } else{
                odd = true;
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
