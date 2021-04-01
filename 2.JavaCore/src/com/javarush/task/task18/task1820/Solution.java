package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(filename1));

        byte[] b1= new byte[file1.available()];
        file1.read(b1,0,file1.available());
        file1.close();

        byte[] b2= new byte[b1.length];
        String s1 = new String(b1);

        String[] s2 = s1.split(" ");
        String s4="";
        String sd="";

        for (String s3 : s2){
            int d = (int)Math.round(Double.parseDouble(s3));
            sd = Integer.toString(d);
            s4 = s4+sd+" ";
        }

        FileOutputStream file2 = new FileOutputStream(filename2);

        file2.write(s4.getBytes());
        file2.close();

    }
}
