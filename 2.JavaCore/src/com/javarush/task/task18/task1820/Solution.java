package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.StringTokenizer;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file1 = br.readLine();
        String file2 = br.readLine();
        try(BufferedReader reader = new BufferedReader(new FileReader(file1));
        FileWriter fw = new FileWriter(file2);){
            StringBuilder sb = new StringBuilder();
            while (reader.ready()){
                sb.append(reader.readLine());
            }
            StringTokenizer st = new StringTokenizer(sb.toString());
            while (st.hasMoreTokens()){
                fw.write(Math.round(Double.parseDouble(st.nextToken(" "))) + " ");
            }
        }
    }
}
