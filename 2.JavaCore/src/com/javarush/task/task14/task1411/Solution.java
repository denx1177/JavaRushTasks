package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = reader.readLine();
        //тут цикл по чтению ключей, пункт 1
        List<String> keysList = new ArrayList<>();
        List<String> keys = Keys.asStringList();
        while(keys.contains(key)){
            keysList.add(key);
            key = reader.readLine();
        }
        {
            //создаем объект, пункт 2
//            List<Person> persons = new ArrayList<>();
            for (String s : keysList) {
                switch(s){
                    case "user":
//                        persons.add(0,new Person.User());
                        person = new Person.User();
                        break;
                    case "loser":
//                        persons.add(0,new Person.Loser());
                        person = new Person.Loser();
                        break;
                    case "coder":
//                        persons.add(0,new Person.Coder());
                        person = new Person.Coder();
                        break;
                    case "proger":
//                        persons.add(0,new Person.Proger());
                        person = new Person.Proger();
                }
                doWork(person); //вызываем doWork
            }
        }
    }

    public static void doWork(Person person) {
        // пункт 3
            // К сожалению это работающее решение не пропускает валидатор,
            // видимо не умеет работать с типом String в switch-case
//        String className = person.getClass().toString();
//        className = className.substring(className.lastIndexOf('$')+1);
//            switch(className){
//                case "User":
//                    ((Person.User)person).live();
//                    break;
//                case "Loser":
//                    ((Person.Loser)person).doNothing();
//                    break;
//                case "Coder":
//                    ((Person.Coder)person).writeCode();
//                    break;
//                case "Proger":
//                    ((Person.Proger)person).enjoy();
//            }
        if (person instanceof Person.User){
            ((Person.User)person).live();
        }else if(person instanceof Person.Loser){
            ((Person.Loser)person).doNothing();
        }else if(person instanceof Person.Coder){
            ((Person.Coder)person).writeCode();
        }else if(person instanceof Person.Proger){
            ((Person.Proger)person).enjoy();
        }
    }
}
