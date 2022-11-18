package com.javarush.task.task14.task1411;

public interface Person {
// Можно было решить с помощью дефолтных пустых методов в интерфейсе, но это не совсем правильно
//  default void live(){}
//  default void doNothing(){}
//  default void writeCode(){}
//  default void enjoy(){}

     class User implements Person {
        void live() { System.out.println("I usually just live."); }
    }

    class Loser implements Person {
        void doNothing() {
            System.out.println("I usually do nothing.");
        }
    }

    class Coder implements Person {
        void writeCode() {
            System.out.println("I usually write code.");
        }
    }

    class Proger implements Person {
        public void enjoy() { System.out.println("It's a wonderful life!"); }
    }

}
