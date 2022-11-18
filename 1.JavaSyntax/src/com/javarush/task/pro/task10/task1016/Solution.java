package com.javarush.task.pro.task10.task1016;

/* 
Прогноз погоды
*/

public class Solution {

    public static void showWeather(City city) {
        System.out.println("В городе " + city.getName() + " сегодня температура воздуха " + city.getTemperature());
    }

    public static void main(String[] args) {
        City city1 = new City("Paris", 15);
        City city2 = new City("Kair", 25);
        showWeather(city1);
    }
}
