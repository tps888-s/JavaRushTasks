package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] list = s.toCharArray();

        for (int i =0; i<list.length; i++) {

            if ( i ==0 || list[i - 1] == ' ')
                System.out.print(Character.toUpperCase(list[i]));
            else System.out.print(list[i]);
        }

        //напишите тут ваш код
    }
}
