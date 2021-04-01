package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String s = reader.readLine();
        char[] c_arr = s.toCharArray();
        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();
         for (char c : c_arr){
             if (isVowel(c)) list1.add(c);
             else if (!isVowel(c) && c!=' ')list2.add(c);
         }

         for (char c : list1){
             System.out.print(c+" ");
         }
         System.out.println();
        for (char c : list2){
            System.out.print(c+" ");
        }

    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}