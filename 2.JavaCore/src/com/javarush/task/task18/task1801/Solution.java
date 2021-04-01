package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        FileInputStream inputStream = new FileInputStream(filename);
        ArrayList<Integer> bytes = new ArrayList<>();
        while (inputStream.available()>0) {
            bytes.add(inputStream.read());
        }
        inputStream.close();
        Collections.sort(bytes);
        System.out.println(bytes.get(bytes.size()-1));

    }
}
