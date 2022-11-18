package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        if (args.length == 0 || !(args[0].equals("-c") || args[0].equals("-u") || args[0].equals("-d"))) {
            return;
        }
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        List<Product> productList = readProductList(fileName);
        ;
        switch (args[0]) {
            case "-c": {
                int nextId = findMaxIdInFile(productList) + 1;
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
                    bw.newLine();
                    bw.append(new Product(nextId, args[1], Double.parseDouble(args[2]), Integer.parseInt(args[3])).toString());
                }
            }
            break;
            case "-d": {
                deleteProductFromList(productList, Integer.parseInt(args[1]));
                saveListToFile(productList, fileName);
            }
            break;
            case "-u": {
                updateProductFromList(productList,
                        new Product(Integer.parseInt(args[1]), args[2], Double.parseDouble(args[3]), Integer.parseInt(args[4])));
                saveListToFile(productList, fileName);
            }

        }
    }

    public static List<Product> readProductList(String fileName) throws IOException {
        ArrayList<Product> productList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while (br.ready()) {
                String inputString = br.readLine();
                productList.add(new Product(Integer.parseInt(inputString.substring(0, 8).trim()),
                        inputString.substring(8, 38),
                        Double.parseDouble(inputString.substring(38, 46).trim()),
                        Integer.parseInt(inputString.substring(46, 50).trim()))
                );
            }
        }
        return productList;
    }

    public static int findMaxIdInFile(List<Product> productList) {
        int max = Integer.MIN_VALUE;
        for (Product product : productList) {
            int id = product.getId();
            max = Math.max(id, max);
        }
        return max;
    }

    public static void deleteProductFromList(List<Product> productList, int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
            }
        }
    }

    public static void updateProductFromList(List<Product> productList, Product newProduct) {
        for (Product product : productList) {
            if (product.getId() == newProduct.getId()) {
                product.setProductName(newProduct.getProductName());
                product.setPrice(newProduct.getPrice());
                product.setQuantity(newProduct.getQuantity());
            }
        }
    }

    public static void saveListToFile(List<Product> productList, String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < productList.size(); i++) {
                bw.append(productList.get(i).toString());
                if (i < productList.size() - 1) {
                    bw.newLine();
                }
            }
        }
    }
}
