package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
// Можно сохранить данные в "свой" буфер, и после записать их в поток записи
// А можно воспользоваться объектом класса ByteArrayOutputStream, который внутри себя наполняет схожий буфер byte[]
//        List<Byte> buffer = new ArrayList<>();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream fis1 = new FileInputStream(file1)) {
            while (fis1.available() > 0) {
//                buffer.add((byte)fis1.read());
                baos.write(fis1.read());
            }
        }
        try (
                FileInputStream fis2 = new FileInputStream(file2);
                FileOutputStream fos = new FileOutputStream(file1);
        ) {
            while (fis2.available() > 0) {
                fos.write(fis2.read());
            }
            baos.writeTo(fos);
//            for (Byte aByte : buffer) {
//                fos.write(aByte);
//            }
        }
    }
}
