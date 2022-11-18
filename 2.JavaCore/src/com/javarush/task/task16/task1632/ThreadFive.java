package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ThreadFive extends Thread {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        String input = "";
        Double number = 0.0;
        Double result = 0.0;
        do{
            try {
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                number = Double.parseDouble(input);
                result += number;
            } catch (NumberFormatException e) {
                if ("N".equals(input)){
                    break;
                }else {
                    System.out.println("Не число");
                }
            }
        }while (true);
        System.out.println(result);

    }
}
