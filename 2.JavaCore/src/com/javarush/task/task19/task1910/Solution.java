package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1= reader.readLine();
        String file2= reader.readLine();

        reader.close();

        BufferedReader r = new BufferedReader(new FileReader(file1));
        BufferedWriter w = new BufferedWriter(new FileWriter(file2));
        int ch1;

        while (r.ready()) {
            ch1 = r.read();
            if (ch1==13 || (ch1>=33 && ch1<=47) || (ch1>=58 && ch1<=64) || (ch1>=91 && ch1<=96) || (ch1>=123 && ch1<=127));
            else w.write(ch1);
        }

        r.close();
        w.close();
    }
}
