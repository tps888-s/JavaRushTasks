package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int id;
        String s1,name;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        while (true) {
            s1 = reader.readLine();
            if (s1.isEmpty()) break;;
            id= Integer.parseInt(s1);
            name = reader.readLine();
            map.put(name,id);
            if (name.isEmpty()) break;


        }

        for (Map.Entry<String,Integer> pair : map.entrySet()){
            System.out.println(pair.getValue() + " " + pair.getKey());
        }
    }
}
