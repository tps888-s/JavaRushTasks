package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        IncomeDataAdapter(IncomeData data){
            this.data=data;
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
            return this.data.getContactLastName()+", "+this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            Integer phone = this.data.getPhoneNumber();
            Integer country_code = this.data.getCountryPhoneCode();
            String city_code="";
            String phone_number="";
            if (phone.toString().length()==10) {
                city_code = phone.toString().substring(0, 3);
                phone_number = phone.toString().substring(3);
            }
            else {
                String phone_num = phone.toString();
                for (int i = phone.toString().length(); i<10; i++){
                    phone_num = "0"+phone_num;
                    }
                city_code = phone_num.substring(0, 3);
                phone_number = phone_num.substring(3);
            }

            return "+"+country_code.toString()+"("+city_code+")"+phone_number.substring(0,3)+"-"+phone_number.substring(3,5)+"-"+phone_number.substring(5);
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}