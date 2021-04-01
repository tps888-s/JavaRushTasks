package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int x=0;
        while (true)
        {
            String s = buffer.readLine();
            if (s.equals("сумма"))
                break;
             else {int n = Integer.parseInt(s);
             x=x+n;}

        }
        System.out.println(x);
    }
}
