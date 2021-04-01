package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {

             public static void main(String[] args) throws Exception {
            // напишите тут ваш код
                 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                 String s = reader.readLine();
                 BufferedReader inStream = new BufferedReader(new InputStreamReader(new FileInputStream(s)));
                 ArrayList<Integer> list = new ArrayList<>();

                 while (inStream.ready()) {

                     int data = Integer.parseInt(inStream.readLine());
                     if (data%2==0) list.add(data);
                     Collections.sort(list);

                 }
                 for (int i : list){
                     System.out.println(i);
                 }

                 inStream.close(); //закрываем потоки
                 reader.close();
        }
    }
