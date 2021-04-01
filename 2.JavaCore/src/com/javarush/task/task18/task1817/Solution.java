package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedInputStream file = new BufferedInputStream(new FileInputStream(args[0]));
        byte[] b= new byte[file.available()];
        file.read(b,0,file.available());
        file.close();
        int count = 0;

        for(byte bt : b){
            if (bt==32) count++;
        }
        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println(df.format(count*1.0/b.length*100));
    }
}
