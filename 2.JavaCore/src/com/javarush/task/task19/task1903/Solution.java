package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("RU", "Russia");
        countries.put("UA", "Ukraine");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements  Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(this.data.getCountryCode());
        }

        @Override
        public String getName() {
            return this.data.getContactLastName() + ", " + this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = String.format("%1$10s",this.data.getPhoneNumber() + "").replace(' ', '0');
            String netCode = String.format("%1$3s",phoneNumber.substring(0, phoneNumber.length()-7)).replace(' ', '0');
            phoneNumber = phoneNumber.substring(phoneNumber.length()-7);
            return "+" + this.data.getCountryPhoneCode() + "(" + netCode + ")" +
                    String.format("%1$s-%2$s-%3$s", phoneNumber.substring(0,3),phoneNumber.substring(3,5),phoneNumber.substring(5));
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}