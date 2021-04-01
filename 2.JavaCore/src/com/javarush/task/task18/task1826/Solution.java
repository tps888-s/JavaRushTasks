package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(args[1]));
        BufferedOutputStream file2 = new BufferedOutputStream(new FileOutputStream(args[2]));
        byte[] b1 = new byte[file1.available()];
        byte[] b2 = new byte[file1.available()];
        file1.read(b1,0,file1.available());

        if (args[0].equals("-e")) {
            for (int i = 0; i < b1.length; i++){
                b2[b1.length-1-i]=b1[i];
            }
        }

        if (args[0].equals("-d")) {
            for (int i = 0; i < b1.length; i++){
                b2[b1.length-1-i]=b1[i];
            }
        }
        file2.write(b2);

        file1.close();
        file2.close();

    }

}
