package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedInputStream file1 = new BufferedInputStream(new FileInputStream(args[0]));
        byte[] b1 = new byte[file1.available()];
        file1.read(b1,0,file1.available());
        file1.close();
        HashMap<Integer, Integer> map = new HashMap<>();



        for (int b : b1) {
            int count=0;
            for (int i = 0; i < b1.length; i++) {
                if (b == b1[i]) count++;
            }

            map.put(b,count);
        }
        ArrayList<Integer> ksorted = new ArrayList<>(map.keySet());
        Collections.sort(ksorted);

        for (int k : ksorted){
            System.out.print((char)k);
            System.out.print(" ");
            System.out.print(map.get(k));
            System.out.println("");
        }


    }
}
