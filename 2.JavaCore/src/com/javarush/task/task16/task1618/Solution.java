package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread thread = new TestThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread{
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}