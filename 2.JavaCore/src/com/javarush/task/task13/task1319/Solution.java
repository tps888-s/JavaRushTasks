package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static class MyClass
    {
        private ArrayList<String> list = new ArrayList<>();
        public void write(String data)
        {
            list.add(data);
        }


        public int available()
        {
            return list.size();
        }
    }
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyClass myObject = new MyClass();
        String s = reader.readLine();
        File file = new File(s);
        FileWriter fileReader = new FileWriter(file); // поток который подключается к текстовому файлу
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader); // соединяем FileWriter с BufferedWitter

        while (true) {
            s = reader.readLine();
            myObject.write(s); //записываем в arraylist
            if (s.equals("exit")) break;
             }

        //System.out.println(myObject.list);


        for(String s1 : myObject.list) {
            bufferedWriter.write(s1 +System.lineSeparator());
            }

        reader.close();
        bufferedWriter.close(); // закрываем поток

    }
}