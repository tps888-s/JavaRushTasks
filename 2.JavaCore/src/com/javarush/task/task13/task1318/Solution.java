package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static class MyClass
    {
        private ArrayList<Integer> list = new ArrayList<>();
        public void write(int data)
        {
            list.add(data);
        }
        public int read()
        {
            int first = list.get(0);
            list.remove(0);
            return first;
        }

        public int available()
        {
            return list.size();
        }
    }
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        BufferedInputStream inStream = new BufferedInputStream(new FileInputStream(s));
        MyClass myObject = new MyClass();

        while (inStream.available() > 0) {
            int data = inStream.read(); //читаем один int из потока для чтения
            myObject.write(data); //записываем прочитанный int в другой поток.
            System.out.print((char)data);
        }

        inStream.close(); //закрываем потоки
        reader.close();

    }
}