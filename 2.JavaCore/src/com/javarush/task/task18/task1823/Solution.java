package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        while (!exit) {
            String fileName = br.readLine();
            if ("exit".equals(fileName)) {
                exit = true;
            } else {
                new ReadThread(fileName);
            }
        }
//        for (Map.Entry<String, Integer> pair : resultMap.entrySet()){
//            System.out.print(pair.getKey() + " ");
//            System.out.println(pair.getValue());
//        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            this.start();
        }

        @Override
        public void run() {
            List<Integer> arrayASCII = new ArrayList<>(Collections.nCopies(256, 0));
            try (FileInputStream fis = new FileInputStream(fileName)) {
                   while (fis.available() > 0) {
                    int data = fis.read();
                    arrayASCII.set(data, arrayASCII.get(data)+1);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int max = Collections.max(arrayASCII);
            for (int i = 0; i < arrayASCII.size(); i++) {
                if (arrayASCII.get(i) == max){
                    resultMap.put(fileName, i);
                }
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
