package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.util.SortedMap;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        File f1 = new File(args[0]);
        FileInputStream r = new FileInputStream(args[0]);
        byte[] bytes = new byte[(int) f1.length()];
        r.read(bytes);
        r.close();

        String s = new String(bytes,"Windows-1251");
        bytes = s.getBytes("UTF-8");

        FileOutputStream w = new FileOutputStream(args[1]);
        w.write(bytes);
        w.close();


    }
}
