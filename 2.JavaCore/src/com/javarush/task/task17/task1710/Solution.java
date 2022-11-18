package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        Integer id = null;
        String name = "";
        Sex sex = null;
        Date date = new Date();

        switch (args[0]) {
            case "-c": {
                switch (args[2]) {
                    case "м":
                        sex = Sex.MALE;
                        break;
                    case "ж":
                        sex = Sex.FEMALE;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = formatter.parse(args[3]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(createPerson(args[1], sex, date));
                break;
            }
            case "-r": {
                System.out.println(readPersonInfo(Integer.parseInt(args[1])));
                break;
            }
            case "-u": {
                id = Integer.parseInt(args[1]);
                switch (args[3]) {
                    case "м":
                        sex = Sex.MALE;
                        break;
                    case "ж":
                        sex = Sex.FEMALE;
                }
                name = args[2];
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    date = formatter.parse(args[4]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                updatePerson(id, name, sex, date);
                break;
            }
            case "-d": {
                deletePerson(Integer.parseInt(args[1]));
            }
        }
// Досадно забыл удалить тестовую строку и не сдал валидатору с 1-ой попытки
//        System.out.println(readPersonInfo(1));
    }

    public static int createPerson(String name, Sex sex, Date birthDate) {
        switch (sex) {
            case MALE:
                allPeople.add(Person.createMale(name, birthDate));
                break;
            case FEMALE:
                allPeople.add(Person.createFemale(name, birthDate));
        }
        return allPeople.size() - 1;
    }

    public static String readPersonInfo(Integer id) {
        Person person = allPeople.get(id);
        String name = null;
        if (person.getName() != null) {
                    name = person.getName();
        }
        String sex = null;
        if (person.getSex() != null) {
            switch (person.getSex()) {
                case MALE:
                    sex = "м";
                    break;
                case FEMALE:
                    sex = "ж";
                    break;
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        String date = null;
        if (person.getBirthDate() != null) {
            date = formatter.format(person.getBirthDate());
        }
        return name + " " + sex + " " + date;
    }

    public static void updatePerson(Integer id, String name, Sex sex, Date birthDate) {
        Person person = allPeople.get(id);
        person.setName(name);
        person.setSex(sex);
        person.setBirthDate(birthDate);
    }

    public static void deletePerson(Integer id) {
        Person person = Person.createMale(null, null);
        person.setSex(null);
        allPeople.set(id, person);
    }

}
