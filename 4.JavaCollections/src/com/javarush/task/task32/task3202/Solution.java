package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
      //  StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
       StringWriter writer = getAllDataFromInputStream(new FileInputStream("c://test/p3.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();

        if (is == null) return writer;

        StringBuilder sb = new StringBuilder("");
        while(is.available() > 0){
            sb.append((char)is.read());
        }

        writer.write(sb.toString());
        return writer;
    }
}