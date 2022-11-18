package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.util.Scanner;

/* 
А что же внутри папки?
*/

public class Solution {

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             DirectoryStream<Path> files = Files.newDirectoryStream(Path.of(scanner.nextLine()))){
//            Path directory = Path.of(scanner.nextLine());
            for (Path path : files) {
                if(Files.isRegularFile(path)){
                    System.out.println(path + THIS_IS_FILE);
                }else if(Files.isDirectory(path)){
                    System.out.println(path + THIS_IS_DIR);
                }
            }
        }
        catch (NotDirectoryException e){
//            e.printStackTrace();
            System.out.println("NotDirectoryException");
        }
        catch (IOException e){
            e.printStackTrace();
        }


        //напишите тут ваш код
    }
}

