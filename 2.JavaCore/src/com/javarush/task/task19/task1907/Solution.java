package com.javarush.task.task19.task1907;

import java.io.*;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        br.close();
        int charFind = 0;
        int hitCounter = 0;
        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("");
            }
        reader.close();
        System.out.println(hitCounter);
    }
    public static int validateCharacterPosition(String word, char ch, int position){
        if (word.substring(position, position+1).equals(String.valueOf(ch))){
            return position+1;
        } else{
            return -1;
        }
    }
}
