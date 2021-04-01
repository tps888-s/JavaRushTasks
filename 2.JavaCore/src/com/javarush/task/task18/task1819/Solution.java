package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(filename1));
        BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(filename2));

        byte[] b1= new byte[file1.available()];
        file1.read(b1,0,file1.available());
        file1.close();

        byte[] b2= new byte[file2.available()];
        file2.read(b2,0,file2.available());
        file2.close();

        FileOutputStream file3 = new FileOutputStream(filename1);

        file3.write(b2);
        file3.write(b1);

        file3.close();
    }
}
