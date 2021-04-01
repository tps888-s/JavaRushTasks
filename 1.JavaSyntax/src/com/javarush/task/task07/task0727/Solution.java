package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listUpperCase = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int l = s.length();
            if (l%2==0) {listUpperCase.add(s);
                listUpperCase.add(s);
                System.out.print(listUpperCase.get(listUpperCase.size()-2));
                System.out.print(" ");
                System.out.println(listUpperCase.get(listUpperCase.size()-1));
            }
            else {listUpperCase.add(s); listUpperCase.add(s);listUpperCase.add(s);
                System.out.print(listUpperCase.get(listUpperCase.size()-3));
                System.out.print(" ");
                System.out.print(listUpperCase.get(listUpperCase.size()-2));
                System.out.print(" ");
                System.out.println(listUpperCase.get(listUpperCase.size()-1));
            }}


        /*for (int i = 0; i < listUpperCase.size(); i++) {
            System.out.println(listUpperCase.get(i));
        }*/
    }
}
