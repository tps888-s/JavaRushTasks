package com.javarush.task.task36.task3605;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Set<Character> set = new TreeSet<>();

        FileInputStream fileReader = new FileInputStream(fileName);


        while (fileReader.available() > 0) {
            int ch = fileReader.read();
            if ((ch > 64 && ch < 91) || (ch > 96 && ch < 123)) {
                set.add(Character.toLowerCase((char) ch));
            }
        }
        int i = 0;

        for (Character c : set) {
            if (i < 5) {
                System.out.print(c);
                i++;
            } else break;
        }

    }
}
