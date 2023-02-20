package com.javarush.task.task19.task1917;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {

    private FileWriter fileWriter;

    public static void main(String[] args) throws IOException {
        FileConsoleWriter fcw = new FileConsoleWriter("C:\\Users\\de1177\\Documents\\java\\de1177\\JavaRushTasks\\resourses\\myFile12.txt");
        char[] buf = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        fcw.write("0123456789", 3, 4);
        fcw.write(buf, 3, 4);
        fcw.close();
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.print((char) c);
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
//  ----       мое решение кривоватое, а далее следует правильное
//        Arrays.asList(cbuf).forEach(System.out ::println);
        System.out.println(new String(cbuf));
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
//   ----   мое решение кривоватое, а далее следует правильное
//        Arrays.asList(Arrays.copyOfRange(cbuf, off, off+len)).forEach(System.out ::println);
        System.out.println(new String(cbuf).substring(off, off + len));
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
