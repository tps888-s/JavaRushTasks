package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());;
        int n1;
        int x=Integer.MIN_VALUE;;
        while (maximum>0) {
            int n = Integer.parseInt(reader.readLine());;

            x=n>x? n:x;

            maximum--;
        }
        //напишите тут ваш код
        maximum = x;
        System.out.println(maximum);
    }
}
