package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedInputStream file = new BufferedInputStream(new FileInputStream(args[0]));
        byte[] b= new byte[file.available()];
        file.read(b,0,file.available());
        file.close();
        int count = 0;

        for(byte bt : b){
            if (bt>=65 & bt<=90) count++;
            if (bt>=97 & bt<=122) count++;
        }
        System.out.println(count);

    }
}
