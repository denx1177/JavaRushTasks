package com.javarush.task.task18.task1822;

import java.util.Locale;

public class Product {
    int id;
    String productName;
    double price;
    int quantity;

    public Product() {
    }

    public Product(int id, String productName, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%-8d%-30.30s%-8.2f%-4.4s", id, productName, price, quantity);
    }
}
