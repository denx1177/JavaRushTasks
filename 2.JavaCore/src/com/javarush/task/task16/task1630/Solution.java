package com.javarush.task.task16.task1630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            System.out.println("IOException input file name");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private Path path;
        private String fileContent = "";

        @Override
        public void setFileName(String fullFileName) {
//            this.path = Path.of(fullFileName); // не принимает валидатор
            this.path = Paths.get(fullFileName);
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            fileContent = "";
            try(BufferedReader reader = Files.newBufferedReader(path);){
                while (reader.ready()) {
                    fileContent += reader.readLine() + " ";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
