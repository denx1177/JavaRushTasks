package com.javarush.task.task12.task1220;

/* 
Класс Human и интерфейсы CanRun, CanSwim
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add public interfaces and a public class here - добавь public интерфейсы и public класс тут
    interface CanRun{
        void run();
    }
    interface CanSwim{
        void swim();
    }
    public abstract class Human implements CanRun, CanSwim{

//        public abstract void run();
//        public abstract void swim();
    }
}
