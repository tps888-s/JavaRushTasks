package com.javarush.task.task30.task3010;

/*
Минимальное допустимое основание системы счисления
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
    try {
        String s = args[0];
        int result = 0;
        boolean check = true;
        char[] charArray = s.toLowerCase().toCharArray();
        Arrays.sort(charArray);
        for (char ch : charArray) {
            if ((ch > 31 && ch < 48) || (ch > 57 && ch < 65) || (ch > 90 && ch < 97) || ch > 122) check = false;
        }
        char maxChar = charArray[charArray.length - 1];
        if (check && (maxChar == 48 || maxChar == 49)) result = 2;
        if (check && (maxChar > 49 && maxChar < 58)) result = Character.getNumericValue(maxChar) + 1;
        if (check && (maxChar > 96 && maxChar < 123)) result = maxChar - 86;

        if (!check) System.out.println("incorrect");
        else System.out.println(result);
    }
    catch (Exception e){

    }
    }
}