package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new FileReader(args[0]));

        ArrayList<String> s_list = new ArrayList<>();
        while (true) {
            String s = r.readLine();
            if (s == null) break;
            s_list.add(s);
        }
        r.close();

        HashMap<String, Double> map = new HashMap<>();

        for (String s : s_list) {
            String[] sp1 = s.split(" ");
            Double sum = 0.0;
            for (String s1 : s_list) {
                String[] sp2 = s1.split(" ");
                if (sp1[0].equals(sp2[0])) sum = sum + Double.parseDouble(sp2[1]);
            }
            map.put(sp1[0], sum);
        }

        Set<String> keySet = map.keySet();
        ArrayList<String> List = new ArrayList<>(keySet);
        Collections.sort(List);

        for (String s : List) {
            System.out.println(s + " " + map.get(s));
        }


    }
}
