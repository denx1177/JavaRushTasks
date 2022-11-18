package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/
// Условия задачи не требовали создания класса обертки, но валидатор пропустил.
public class TxtInputStream extends FileInputStream {
private FileInputStream component;
    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException {
        super(fileName);
        if (!fileName.endsWith(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }else{
            this.component = new FileInputStream(fileName);
        }
    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
        String filename = "C:\\tmp\\result.txt";
        new TxtInputStream(filename);
    }
}

