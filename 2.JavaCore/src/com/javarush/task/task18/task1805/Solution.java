package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        Set<Integer> bytes = new HashSet<Integer>();
        while (inputStream.available()>0) {
            bytes.add(inputStream.read());
        }
        inputStream.close();



        ArrayList<Integer> sortedbytes = new ArrayList<>();

        for (Integer set : bytes) {
            sortedbytes.add(set);
            }
        Collections.sort(sortedbytes);

       for (Integer sorted : sortedbytes)
       {System.out.print(sorted);
       System.out.print(" ");
       }

    }
}
