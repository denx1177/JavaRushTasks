package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Отслеживаем изменения
*/

public class Solution3 {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String filename1;
        String filename2;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            filename1 = console.readLine();
            filename2 = console.readLine();
        }
        Optional<String>[][] b = new Optional[2][2];
        try (BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));
             BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(filename2)));) {
            b[0][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
            b[0][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
            b[1][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
            b[1][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
//            boolean err = false;
            boolean modified = false;
            while ((b[0][0].isPresent() || b[0][1].isPresent())) {
                String error = String.format(":%s\t:%s", b[0][0].orElse("-null-"), b[0][1].orElse("-null-"));
                Type type = null;
                if (b[0][0].isPresent() && b[0][1].isPresent() && b[0][0].get().equals(b[0][1].get())) {
                    type = Type.SAME;
                } else if (!b[0][0].isPresent() || (b[1][1].isPresent() && b[0][0].get().equals(b[1][1].get()))) {
                    type = Type.ADDED;
                } else if (!b[0][1].isPresent() || (b[1][0].isPresent() && b[0][1].get().equals(b[1][0].get()))) {
                    type = Type.REMOVED;
                }
                String line = null;
                if (type != null) {
                    switch (type) {
                        case SAME:
                            line = b[0][0].get();
                            b[0][0] = b[1][0];
                            b[1][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
                            b[0][1] = b[1][1];
                            b[1][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
                            modified = false;
                            break;
                        case REMOVED:
                            if (modified) {
                                throw new IllegalStateException("Malformed input files: ADDED or REMOVED stepRemoved by step " + error);
                            }
                            modified = true;
                            line = b[0][0].get();
                            b[0][0] = b[1][0];
                            b[1][0] = Optional.ofNullable(br1.ready() ? br1.readLine() : null);
                            break;
                        case ADDED:
                            if (modified) {
                                throw new IllegalStateException("Malformed input files: ADDED or REMOVED stepRemoved by step " + error);
                            }
                            modified = true;
                            line = b[0][1].get();
                            b[0][1] = b[1][1];
                            b[1][1] = Optional.ofNullable(br2.ready() ? br2.readLine() : null);
                            break;
                    }
                    lines.add(new LineItem(type, line));
                } else {
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
