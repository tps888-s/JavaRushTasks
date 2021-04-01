package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = r.readLine();

            String[] str1 = s1.split("\\?");

            String[] str2 = str1[1].split("\\&");


            String[] str3 = new String[2];
            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<String> x = new ArrayList<>();
            for (int i = 0; i < str2.length; i++) {

                str3 = str2[i].split("=");
                list.add(str3[0]);
                if (str3[0].equals("obj")) {
                    x.add(str3[1]);
                }
                str3 = null;
            }
            for (String s : list) {
                System.out.print(s+" ");
            }
            System.out.println("");
            if (x.size()>0) {
                try {
                    double value = Double.parseDouble(x.get(0));
                    alert(value);
                } catch (Exception e) {
                    alert(x.get(0));
                }
            }

    }
        catch(
    Exception e)

    {
        System.out.println(e);
    }

}


    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
