package com.javarush.task.task16.task1632;

public class ThreadThree extends Thread{
    @Override
    public void run() {
        boolean isCatched = false;
        while (!isCatched) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
//                isCatched = true;
            }
        }
    }
}
