package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            Thread current = Thread.currentThread();
//            while (!current.isInterrupted()) {
//Внешний цикл с проверкой условия существования исключения не работает, по причине того, что после того,
//как исключение поймано и обработано, метод ((Thread)current).isInterrupted() = false
// что говорит о том, что после обработки исключения полю interrupted присваивается значение false
// При отладке это проверить практически невозможно, ввиду того, что обработка исключения при обычном исполнении
// приходится на выполнение метода Thread.sleep(), что при отладке плохо эмулируется.
// При обычном выполнении это предположение проверяется с помощью вывода отладочных сообщений в консоль
            try {
                //напишите тут ваш код
                while (!current.isInterrupted()) {
                    Thread.sleep(1000);
                    this.seconds++;
//                    System.out.println(current.isInterrupted()); // Отладочное сообщение 1
//                    current.interrupt(); // Отладочный метод 3
                }
            } catch (InterruptedException e) {
//                System.out.println("Interrupt"); // Отладочное сообщение 2
                System.out.println(this.seconds);
            }
//ВНИМАНИЕ !!! смотри реализацию метода interrupt() в классе Thread!!!
// Только вызов из самой нити останавливает её через return !!!  current.interrupt(); Смотри отладочный метод 3
        }
    }
}
