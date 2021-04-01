package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileReader r = new FileReader(file1);
        FileWriter w = new FileWriter(file2);
        int count = 1;

        while (r.ready()) //пока есть непрочитанные байты в потоке ввода
        {

            int data = r.read(); //читаем один символ (char будет расширен до int)

            //System.out.println((char)data);

            if (count%2==0) w.write(data); //пишем один символ (int будет обрезан/сужен до char)

            count++;
        }

        r.close();
        w.close();

    }
}
