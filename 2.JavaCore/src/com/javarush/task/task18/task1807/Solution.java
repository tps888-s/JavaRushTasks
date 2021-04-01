package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

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

        HashMap<Integer, Integer> repeatbytes = new HashMap();
        for (int i =0; i<bytes.size(); i++){
            int val = 0;
            int ch = bytes.get(i);
            for (int ch1 : bytes){
                if (ch==ch1) val++;
            }
            repeatbytes.put(ch,val);
        }


        for (HashMap.Entry<Integer, Integer> pair : repeatbytes.entrySet()) {
            if (pair.getKey()==44) {
                System.out.print(pair.getValue());

            }
        }

    }
}
