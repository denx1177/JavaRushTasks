package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String filename1;
        String filename2;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = console.readLine();
            filename2 = console.readLine();
        }
        try (BufferedReader br1 = new BufferedReader(new FileReader(filename1));
             BufferedReader br2 = new BufferedReader(new FileReader(filename2));) {
            Optional<String>[][] b = new Optional[2][2];    // declare a buffer
            //initial buffer filling
            b[0][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
            b[0][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
            b[1][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
            b[1][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
            boolean modified = false;  // mismatch variable declaration
            while ((b[0][0].isPresent() || b[0][1].isPresent())) {  //work only if there is read data
                String error = String.format(":%s\t:%s", b[0][0].orElse("-null-"), b[0][1].orElse("-null-"));
                Type type = null;  // reset read data type
                // determining the type of read data
                if (b[0][0].isPresent() && b[0][1].isPresent() && b[0][0].get().equals(b[0][1].get())) {
                    type = Type.SAME;
                } else if (!b[0][0].isPresent() || (b[1][1].isPresent() && b[0][0].get().equals(b[1][1].get()))) {
                    type = Type.ADDED;
                } else if (!b[0][1].isPresent() || (b[1][0].isPresent() && b[0][1].get().equals(b[1][0].get()))) {
                    type = Type.REMOVED;
                }
                String line = null; //initial result data variable
                if (type != null) {
                    if ((type == Type.REMOVED) || (type == Type.ADDED)) {
                        if (modified) { // illegal data type repetition definition
                            throw new IllegalStateException("Malformed input files: ADDED or REMOVED stepRemoved by step " + error);
                        }
                        modified = true;
                    } else {
                        modified = false;
                    }
                  // buffer shift based on data type
                    if ((type == Type.SAME) || (type == Type.ADDED)) {
                        line = b[0][1].get();
                        b[0][1] = b[1][1];
                        b[1][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
                    }
                    if ((type == Type.SAME) || (type == Type.REMOVED)) {
                        line = b[0][0].get();
                        b[0][0] = b[1][0];
                        b[1][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
                    }
                    lines.add(new LineItem(type, line)); //result formation
                } else { // throwing an exception in case of invalid data
                    throw new IllegalStateException("Malformed input files: " + error);
                }
            }
        }
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
