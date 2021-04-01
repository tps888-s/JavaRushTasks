package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws   Exception{
//read all data by lines from file1
        BufferedReader  r = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> lines = new ArrayList<>();
        while(true){
            String s1 = r.readLine();
            if (s1==null) break;
            lines.add(s1);
        }
        r.close();

        ArrayList<String> words = new ArrayList<>();

        for (String line : lines){
        String[] split_words = line.split(" ");

        for (String w : split_words){
            if (w.matches(".*\\d.*")) words.add(w);
        }

        }

        FileWriter w = new FileWriter(args[1]);
        for (String ww : words){
            w.write(ww+" ");
        }
        w.close();


    }
}
