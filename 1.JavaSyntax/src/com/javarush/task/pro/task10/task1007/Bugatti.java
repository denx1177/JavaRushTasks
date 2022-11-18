package com.javarush.task.pro.task10.task1007;

/* 
С крышей или без? Вот в чем вопрос
*/

public class Bugatti {
    private String color;
    private int year;
    private String body;

    public Bugatti() {
        this.color = "BLACK";
        this.year = 2020;
        this.body = "Coupe";
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
