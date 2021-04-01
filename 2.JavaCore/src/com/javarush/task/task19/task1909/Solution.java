package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file1));
        BufferedWriter w = new BufferedWriter(new FileWriter(file2));
        char ch1;

        while (r.ready()) {
            ch1 = (char)r.read();
            if (ch1=='.') ch1='!';
            w.write((int)ch1);

        }

        r.close();
        w.close();


    }
}
