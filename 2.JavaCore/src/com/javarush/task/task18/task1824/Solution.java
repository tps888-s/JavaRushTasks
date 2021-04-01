package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<FileInputStream> streams = new ArrayList<>();
        String filename="";

        while (true) {
            try {
                filename = reader.readLine();
                streams.add(new FileInputStream(filename));
            }

            catch (Exception e){
                System.out.println(filename);
                break;
            }
        }
        try {
            reader.close();
            for (FileInputStream f : streams){
                f.close();
            }
        }
        catch (IOException e){

        }
    }
}
