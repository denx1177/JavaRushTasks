package com.javarush.task.task16.task1627;

import java.util.ArrayList;
import java.util.List;

/* 
Поиграем?
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;

        public static List<String> steps = new ArrayList<String>();

        static {
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() {
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) {
            }
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
            int actionCount = 0;
            while (actionCount < OnlineGame.steps.size()) {
                System.out.println(getName() + ":" + OnlineGame.steps.get(actionCount++));
                try {
                    Thread.sleep(1000 / rating);
                } catch (InterruptedException e) {
                    System.out.println(getName() + ":проиграл");
                    actionCount = OnlineGame.steps.size();
//                    return; // по всей видимости ЗАВЕРШАЕТ работу ВСЕЙ нити !!!
                }
/*
Проверку на завершение работы можно проводить внутри цикла по условному оператору if(){...}
если в конкурентных нитях, в обработчике исключения прерывания нельзя вызвать return
для завершения нити. Если же конкурентные нити можно завершить в обработчике прерывания
то завершающие шаги после выполнения цикла работы можно вынести ПОСЛЕ самого цикла
Размещение проверки и установка флага isWinnerFound ПОСЛЕ Thread.sleep() с обработчиком
прерывания, по условию задачи, что бы отработало 4 паузы Thread.sleep().
В случае помещения условия ПЕРЕД паузой, требуется метод return для завершения нити и гарантии
НЕ ПОПАДАНИЯ в обработку прерывания по внешнему interrupt()
 */
//                if (actionCount == OnlineGame.steps.size() && !OnlineGame.isWinnerFound){
//                    System.out.println(getName() + ":победитель!");
//                    OnlineGame.isWinnerFound = true;
////                    return;
//                }
            }
// Т.к. по прерыванию в блоке catch завершается работа конкурентных нитей, то
// завершающие команды можно вынести из цикла и условного оператора if () {...}
            if(!OnlineGame.isWinnerFound) {
                System.out.println(getName() + ":победитель!");
                OnlineGame.isWinnerFound = true;
            }
        }
    }
}
