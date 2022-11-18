package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        String fileName = "";
        List<String> nameList = new ArrayList<>();
        while (!exit){
            fileName = br.readLine();
            if ("end".equals(fileName)) {
                exit = true;
            } else {
                nameList.add(fileName);
            }
        }
        Collections.sort(nameList);
        System.out.println(nameList);
        fileName = nameList.get(0);
        fileName = fileName.substring(0, fileName.lastIndexOf("."));
        System.out.println(fileName);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName, true))){
            for (String s : nameList) {
                try(BufferedInputStream bis = new BufferedInputStream (new FileInputStream(s))){
                    while(bis.available() > 0){
                        baos.write(bis.read());
                    }
                }
            }
            baos.writeTo(bos);
        }
    }
}
