package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        //I, V, X, L, C, D, M
        int result = 0;
        char[] chars = s.toLowerCase().toCharArray();
        ArrayList<Character> list = new ArrayList<>();

        for (int i = 0; i < chars.length; i++){
            list.add(chars[i]);

        }
        list.add('z');

                for (int i = 0; i < list.size() - 1; i++) {

                    if (list.get(i) == 'i') {
                        if (list.get(i + 1) == 'v' || list.get(i + 1) == 'x') result -= 1;
                        else result += 1;
                    }

                    if (list.get(i) == 'v') result += 5;

                    if (list.get(i) == 'x') {
                        if (list.get(i + 1) == 'l' || list.get(i + 1) == 'c') result -= 10;
                        else result += 10;
                    }
                    if (list.get(i) == 'l') result += 50;

                    if (list.get(i) == 'c') {
                        if (list.get(i + 1) == 'd' || list.get(i + 1) == 'm') result -= 100;
                        else result += 100;
                    }


                    if (list.get(i) == 'd') result += 500;

                    if (list.get(i) == 'm') result += 1000;

                }

        return result;
    }
}
