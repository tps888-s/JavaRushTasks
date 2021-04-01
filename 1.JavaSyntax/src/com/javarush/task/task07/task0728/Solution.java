package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        GregorianCalendar cannes = new GregorianCalendar(216, Calendar.AUGUST, 2);
        cannes.set(Calendar.ERA, GregorianCalendar.BC);

        DateFormat df = new SimpleDateFormat("dd MMM yyy GG");
        System.out.println(df.format(cannes.getTime()));

    }
}
