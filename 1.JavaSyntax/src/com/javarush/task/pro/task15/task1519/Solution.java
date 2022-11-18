package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path sourceDirectory = Path.of(scanner.nextLine());
        Path targetDirectory = Path.of(scanner.nextLine());
        try (DirectoryStream<Path> files = Files.newDirectoryStream(sourceDirectory)) {
            if (Files.notExists(targetDirectory)) {
                Files.createDirectories(targetDirectory);
            }
            for (Path path : files) {
                if (Files.isRegularFile(path)) {
//                    Path targetDirFile = Path.of(targetDirectory.toString() + "\\" + path.getFileName().toString());
                    Path targetDirFile = targetDirectory.resolve(path.getFileName());
//                    Files.copy(path, targetDirFile, StandardCopyOption.REPLACE_EXISTING);
                    Files.deleteIfExists(targetDirFile);
                    Files.copy(path, targetDirFile);
                }
            }
        }
        catch (NotDirectoryException e) {
//            e.printStackTrace();
            System.out.println("NotDirectoryException");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

