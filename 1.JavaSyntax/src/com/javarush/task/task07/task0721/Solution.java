package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

         //напишите тут ваш код

        int[] list = new int[20];
        for (int i=0; i<20; i++){
            int x = Integer.parseInt(reader.readLine());
            list[i]=x;
        }
        Arrays.sort(list);


        int maximum = list[19];
        int minimum = list[0];

        //напишите тут ваш код

        System.out.print(maximum + " " + minimum);
    }
}
