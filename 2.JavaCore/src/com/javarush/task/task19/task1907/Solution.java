package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        ArrayList<String> list = new ArrayList<>();
        String all_data = "";

        FileReader r = new FileReader(file1);

        while (r.ready()) {

            char ch1 = (char)r.read();

            list.add(Character.toString(ch1));

        }

        for (String s : list){
            all_data = all_data+s;
        }

        String[] words = all_data.split("\\W");

        int count = 0;

        for (String w : words){
            if (w.equals("world")) count++;
        }
        System.out.print(count);

        r.close();

    }
}
