package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName =  args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];


        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        byte[] bytes = new byte[text.length()];
        raf.seek(number);
        raf.read(bytes,0, text.length());

        raf.seek(raf.length());

        if (text.equals(new String(bytes))) {
            raf.write("true".getBytes());
        }
        else {
            raf.write("false".getBytes());
        }
    }
}
