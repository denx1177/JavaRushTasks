package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution2 {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String filename1;
        String filename2;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = console.readLine();
            filename2 = console.readLine();
        }
        List<String> lines1 = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(filename2)));) {
            while (br1.ready()) {
                lines1.add(br1.readLine());
            }
            while (br2.ready()) {
                lines2.add(br2.readLine());
            }
        }
        int size1 = lines1.size();
        int size2 = lines2.size();
        int i = 0;
        int j = 0;
        while (i < size1 || j < size2) {
            if (i < size1) {
                if (j < size2) {
                    if (lines1.get(i).equals(lines2.get(j))) {
                        lines.add(new LineItem(Type.SAME, lines1.get(i)));
                        i += 1;
                        j += 1;
                    } else if ((i + 1) < size1) {
                        if (lines1.get(i + 1).equals(lines2.get(j))) {
                            lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                            i += 1;
                        } else if ((j + 1) < size2) {
                            if (lines1.get(i).equals(lines2.get(j + 1))) {
                                lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                                j += 1;
                            } else {
                                throw new RuntimeException("wrong file2 data ab cd");
                            }
                        } else throw new RuntimeException("wrong file2 data ab c");
                    } else if ((j + 1) < size2) {
                        if (lines1.get(i).equals(lines2.get(j + 1))) {
                            lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                            j += 1;
                        } else {
                            throw new RuntimeException("wrong file2 data a cd");
                        }
                    } else {
                        throw new RuntimeException("wrong file2 data a c");
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, lines1.get(i)));
                    i += 1;
                }
            } else {
                lines.add(new LineItem(Type.ADDED, lines2.get(j)));
                j += 1;
            }
        }
//        for (int k = 0; k < lines.size(); k++) {
//            System.out.println(lines.get(k).type + " " + lines.get(k).line);
//        }
        lines.forEach(System.out::println);

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
