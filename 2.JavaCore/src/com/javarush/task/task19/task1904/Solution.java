package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("C:\\\\tmp\\\\data.txt"));
        PersonScannerAdapter psa = new PersonScannerAdapter(sc);
        Person person = psa.read();
        System.out.println(person);
        Person person1 = psa.read();
        System.out.println(person1);
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = this.fileScanner.nextLine();
            StringTokenizer st = new StringTokenizer(str);
            int i = 0;
            String firstName = "";
            String middleName = "";
            String lastName = "";
            List<String> dateString = new ArrayList<>();
            while (st.hasMoreTokens()) {
                switch (i){
                    case 0: lastName = st.nextToken(); i++; break;
                    case 1: firstName = st.nextToken(); i++; break;
                    case 2: middleName = st.nextToken(); i++; break;
                    case 3: dateString.add(st.nextToken());
                }
            }
            int year = Integer.parseInt(dateString.get(2));
            int month = Integer.parseInt(dateString.get(1));
            int day = Integer.parseInt(dateString.get(0));
            Date date = new Date(year-1900, month-1, day);
            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
