package com.javarush.task.task16.task1632;

public class ThreadTwo extends Thread{
    @Override
    public void run() {
        boolean isCatched = false;
        while (!isCatched) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
                isCatched = true;
            }
        }
    }
}
