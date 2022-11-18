package com.javarush.task.task16.task1632;

public class ThreadFour extends Thread implements Message{
    @Override
    public void showWarning() {
        if(this.isAlive()){
            this.interrupt();
        }
    }

    @Override
    public void run() {
        boolean isCatched = false;
        while (!isCatched) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                isCatched = true;
            }
        }
    }
}
