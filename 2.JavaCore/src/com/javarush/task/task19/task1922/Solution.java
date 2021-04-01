package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws   Exception{
//read file name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();

        reader.close();
//read data from file by lines
         BufferedReader r = new BufferedReader(new FileReader(file1));

         ArrayList<String> lines = new ArrayList<>();

        while (true){
            String s1 = r.readLine();
            if (s1==null) break;
            lines.add(s1);
        }
        r.close();
//compare file data with words

        for (String s : lines){
            int count = 0;
            String[] slova = s.split(" ");

            for (String slovo : slova) {
                for (String w : words) {
                    if (slovo.equals(w)) count++;
                }
            }
            if(count==2) System.out.println(s);

        }

    }
}
