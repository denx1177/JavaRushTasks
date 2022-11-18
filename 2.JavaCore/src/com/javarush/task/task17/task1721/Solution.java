package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

//    public static void readFileLinesToList(Path path, List<String> lines) throws IOException {
//        List<String> lines = new ArrayList<String>();
//        try(BufferedReader reader = Files.newBufferedReader(path);){
//            while (reader.ready()) {
//                lines.add(reader.readLine());
//            }
//        } catch (IOException e) {
//            throw e;
//        }
//        lines = Files.readAllLines(path);
//        return (ArrayList)lines;
//    }

    public static void main(String[] args) {
        String firstFileName = "";
        String secondFileName = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException input file name");
            e.printStackTrace();
        }
        Path pathOne = Paths.get(firstFileName);
        Path pathTwo = Paths.get(secondFileName);

        try {
            allLines = Files.readAllLines(pathOne);
            forRemoveLines = Files.readAllLines(pathTwo);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
// была приватная статическая переменная private static Solution instance = new Solution();
// Вариант вызова instance.joinData() не пропускал валидатор. Было потрачено 6 попыток.
            new Solution().joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
            System.out.println("CorruptedDataException message");
        }
        System.out.println(allLines);
    }

    public void joinData() throws CorruptedDataException {
//        List<String> lines = (List<String>)allLines.clone();//не даёт использовать clone()
// по причине отсутствия доступа к protected методу clone()
        List<String> lines = new ArrayList<>(allLines); // этот вариант подходит,
// т.к. создаёт копии элементов ArrayList<String> которые ссылаются на immutable
// объекты String и их изменение/удаление не отражается на исходном списке, в конце метода,
// как итого его работы, целевой объект должен получить ссылку на рабочий объект. Это
// является транзакционным подходом, когда исключение или ошибка в процессе выполнения
// обработки данных не фиксируются в исходном объекте. Вариант с конструктором аналогичен
// следующему методу: dest.addALL(src);
//        List<String> lines = new ArrayList<>();
//        lines.addAll(allLines);
//-------------------
        //        Collections.copy(lines, allLines); // метод предполагает, что lines
// инициализирован количеством элементов не меньше что allLines
//-------------------
//        List<String> lines = List.copyOf(allLines); // Этот метод не подходит, т.к.
        // List.copyOf() создаёт НЕИЗМЕНЯЕМУЮ (immutable) коллекцию. Из неё
        // нельзя удалять/добавлять/изменять элементы
//-------------------
//        List<String> lines = allLines.subList(0, allLines.size()-1);
// Этот метод предполагает создание рабочего объекта из набора элементов исходного
// объекта, и не предполагает копирование ссылки на рабочий объект в исходный, т.о.
// это не транзакционный подход (в случае исключения или сбоя, часть работы будет зафиксирована

        if (lines.containsAll(forRemoveLines)){
            if (lines.removeAll(forRemoveLines)){
                allLines = lines;
            }
        }else{
//            allLines = new ArrayList<String>();
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
