package com.javarush.task.pro.task15.task1523;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/* 
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);
        /**
         * Что касается <setDoOutput(true)>, то почитать про него можно здесь:
         * https://docs.oracle.com/javase/7/docs/api/java/net/URLConnection.html
         * Суть такова, что в рамках установленного соединения <connection> можно разрешать и запрещать ввод и/или вывод данных. По умолчанию ввод данных разрешён (connection.setDoInput(true)), а вот вывод данных по умолчанию запрещён (connection.setDoOutput(false)).
         * Поэтому, чтобы мы могли отправить данные после установления соединения, необходимо разрешить их отправку!
         */
        try(OutputStream output = connection.getOutputStream();
        PrintStream sender = new PrintStream(output)){
//            output.write(1);
            sender.println(1);
        }
        try(InputStream input = connection.getInputStream();
        BufferedReader reader  = new BufferedReader(new InputStreamReader(input))){
        while(reader.ready()){
            System.out.println(reader.readLine());
        }
        }
    }
}

