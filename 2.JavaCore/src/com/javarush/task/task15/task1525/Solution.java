package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();




    static{
        try {
            FileInputStream fr = new FileInputStream(Statics.FILE_NAME);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(new InputStreamReader(fr));
            // считаем сначала первую строку
            String s;
            while (true) {
                s = reader.readLine();
                if (s=="") break;
                lines.add(s);
            }
        }
        catch (Exception e){

        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
