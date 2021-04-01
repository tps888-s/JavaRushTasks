package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws  Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file));
        ArrayList<String> lines = new ArrayList<>();

        while (true){
            String l1 = r.readLine();
            if (l1==null) break;
            lines.add(l1);
        }
        r.close();

        ArrayList<String> newlines = new ArrayList<>();

        for (String s : lines){
            char[] ch_arr1 = s.toCharArray();
            int size = ch_arr1.length;
            char[] ch_arr2 = new char[size];

            for (int i = 0; i <size; i++){
                ch_arr2[size-1-i]= ch_arr1[i];
            }
            newlines.add(new String(ch_arr2));
        }

        for (String s : newlines){
            System.out.println(s);
        }
    }
}
