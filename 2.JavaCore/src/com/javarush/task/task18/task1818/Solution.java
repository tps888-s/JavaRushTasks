package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileOutputStream file1 = new FileOutputStream(filename1,true);
        BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(filename2));
        BufferedInputStream file3 = new BufferedInputStream(new FileInputStream(filename3));

        byte[] b2= new byte[file2.available()];
        file2.read(b2,0,file2.available());
        file2.close();

        byte[] b3= new byte[file3.available()];
        file3.read(b3,0,file3.available());
        file3.close();

        file1.write(b2);
        file1.write(b3);

        file1.close();

    }
}
