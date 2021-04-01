package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(isDateOdd("May 1 2013"));
    }

    public static boolean isDateOdd(String date) throws Exception {

        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date date1 = format.parse(date);
        Date startdate = new Date();
        startdate.setMonth(0);
        startdate.setYear(date1.getYear());
        startdate.setDate(1);
        startdate.setHours(0);
        startdate.setMinutes(0);
        startdate.setSeconds(0);
        long chdate = (date1.getTime()-startdate.getTime()+1000) / (1000*60*60*24)+1;
        if (chdate%2!=0) return true;
        else return false;
    }
}
