package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }


    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        ArrayList<String> lines = new ArrayList<>();
        BufferedReader r = new BufferedReader(new FileReader(file1));

        while (true){
            String l1 = r.readLine();
            if (l1==null) break;
            lines.add(l1);
        }
        r.close();

        String newlines = "";

        for(String s : lines){
            String[] words = s.split(" ");

            for(String w: words){
                if(w.matches("\\d+")){
                    int x = Integer.parseInt(w);
                    if (x>=0 && x<13) w = map.get(x);
                }
                newlines = newlines + w + " ";
            }
            newlines.trim();
            newlines = newlines + System.lineSeparator();
        }

        System.out.println(newlines);
        /*FileWriter w = new FileWriter(file1);
        w.write(newlines);
        w.close();*/
    }
}
