package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        System.out.println(hen.getDescription());
    }

    static class HenFactory implements Country{
        static Hen getHen(String country) {
            //напишите тут ваш код
            Hen hen = null;
            switch (country){
                case RUSSIA:
                   hen = new RussianHen();
                    break;
                case UKRAINE:
                    hen = new UkrainianHen();
                    break;
                case MOLDOVA:
                    hen = new MoldovanHen();
                    break;
                case BELARUS:
                    hen = new BelarusianHen();
            }
            return hen;
        }
    }


}
