package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = r.readLine();
            if (s.equals("exit")) break;
            char[] charArray = s.toCharArray();
            boolean isdouble=false;
            for (char c : charArray) {
             if (c=='.')   isdouble=true;
            }

            if (isdouble) {
                try {
                    Double value = Double.parseDouble(s);
                    print(value);
                }
                catch (Exception e) {
                  print(s);
                }
            }
            else {
                try {
                    int value = Integer.parseInt(s);
                    if (value>0 && value<128) print((short) value);
                    if (value<=0 || value>=128) print((Integer) value);
                }
                catch (Exception e) {
                    print(s);
                }
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
