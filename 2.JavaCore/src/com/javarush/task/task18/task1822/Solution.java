package com.javarush.task.task18.task1822;


import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        System.out.println(findProductInFileById(fileName, args[0]));
    }

    public static String findProductInFileById(String fileName, String findId) throws IOException {
        String result ="";
//        Product product = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String inputString = br.readLine();
                int firstSpace = inputString.indexOf(' ');
                if (inputString.substring(0, firstSpace).equals(findId)){
                    result = inputString;
                }
//                int lastSpace = inputString.lastIndexOf(' ');
//                int quantity = Integer.parseInt(inputString.substring(lastSpace+1));
//                int preLastSpace = inputString.lastIndexOf(' ', lastSpace-1);
//                Double price = Double.parseDouble(inputString.substring(preLastSpace + 1, lastSpace));
//                String productName = inputString.substring(firstSpace + 1, preLastSpace);
//                product = new Product(id,productName,price,quantity);
            }
        }
        return result;
    }
}
