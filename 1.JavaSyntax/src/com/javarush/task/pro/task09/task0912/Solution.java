package com.javarush.task.pro.task09.task0912;

/* 
Проверка URL-адреса
*/

public class Solution {
    public static void main(String[] args) {
        String[] urls = {"https://javarush.ru", "https://google.com", "http://wikipedia.org", "facebook.com", "https://instagram", "codegym.cc"};
        for (String url : urls) {
            String protocol = checkProtocol(url);
            String domain = checkDomain(url);

            System.out.println("У URL-адреса - " + url + ", сетевой протокол - " + protocol + ", домен - " + domain);
        }
    }

    public static String checkProtocol(String url) {
        String result = "неизвестный";
        if (url.startsWith("http:/"))
        {
            result = "http";
        }
        else if (url.startsWith("https:/"))
        {
            result = "https";
        }
        return result;
    }

    public static String checkDomain(String url) {
        String result = "неизвестный";
        if (url.endsWith(".com"))
        {
            result = "com";
        }
        else if (url.endsWith(".net"))
        {
            result = "net";
        }else if (url.endsWith(".org"))
        {
            result = "org";
        }else if (url.endsWith(".ru"))
        {
            result = "ru";
        }
        return result;
    }
}
