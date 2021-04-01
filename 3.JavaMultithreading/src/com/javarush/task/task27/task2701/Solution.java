package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        boolean found = false;
        int max = string.length() - substring.length();
        int check = 0;
        label:
        for (int i = 0; i <= max; i++) {
            int length = substring.length();
            //int j = i;

            for (int k = 0 ; k < length; k++) {
                if (string.charAt(i+k) == substring.charAt(k)) {
                    check++;
                }
            }
        }
        if (check >= substring.length()) found = true;
        return found;
    }
}

