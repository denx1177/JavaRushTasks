package com.javarush.task.pro.task10.task1010;

import java.util.Objects;

/* 
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Iphone)) return false;
//        if (!(o instanceof Iphone)) return false;
        Iphone iphone = (Iphone) o;
//        -----------------------------------------1.
//        boolean objOneEquals = false;
//        if (model == null) {
//            objOneEquals = iphone.model == null;
//        } else {
//            objOneEquals = model.equals(iphone.model);
//        }
//        boolean objTwoEquals = false;
//        if (color == null) {
//            objTwoEquals = iphone.color == null;
//        } else {
//            objTwoEquals = color.equals(iphone.color);
//        }
//        boolean objOneEquals = model == null ? iphone.model == null : model.equals(iphone.model);
//        boolean objTwoEquals = color == null ? iphone.color == null : color.equals(iphone.color);
//        return price == iphone.price && objOneEquals && objTwoEquals;
//        -----------------------------------------2.
//        return (price == iphone.price) &&
//                ((model == null && iphone.model == null) || (model != null && model.equals(iphone.model))) &&
//                ((color == null && iphone.color == null) || (color != null && color.equals(iphone.color)));

        return (price == iphone.price) && Objects.equals(model, iphone.model) && Objects.equals(color, iphone.color);
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
