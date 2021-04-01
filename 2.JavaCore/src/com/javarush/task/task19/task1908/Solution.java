package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file1));
        BufferedWriter w = new BufferedWriter(new FileWriter(file2));
        ArrayList<String> list = new ArrayList<>();
        char ch1;
        String all_data="";


        while (r.ready()) {
            ch1 = (char)r.read();
            list.add(Character.toString(ch1));
        }

        for (String s : list){
            all_data = all_data + s;
        }

        String[] symbols = all_data.split(" ");

        for (String s : symbols){
            if (s.matches("\\d+"))  w.write(s+" ");


        }

        r.close();
        w.close();


    }
}
