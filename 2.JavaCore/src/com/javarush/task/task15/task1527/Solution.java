package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        //напишите тут ваш код
        StringTokenizer st = new StringTokenizer(url, "?");
        String token = "";
        while (st.hasMoreTokens()) {
            token = st.nextToken();
        }
        st = new StringTokenizer(token, "&");
        List<String> paramsDraft = new ArrayList<String>();
        while (st.hasMoreTokens()) {
            paramsDraft.add(st.nextToken());
        }
        Map<String, String> params = new HashMap<>();
        for (String s : paramsDraft) {
            String key = "";
            String value = "";
            if (s.contains("=")) {
                key = s.substring(0, s.indexOf("="));
                value = s.substring(s.indexOf("=") + 1);
                System.out.print(key + " ");
                params.put(key, value);
            } else {
                params.put(s, "");
                System.out.print(s + " ");
            }
        }
        System.out.println();
        if(params.containsKey("obj")){
         String value = params.get("obj");
                try {
                    Double d = Double.parseDouble(value);
                    alert(d);
                } catch (NumberFormatException e) {
//                        e.printStackTrace();
                    alert(value);
                }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
