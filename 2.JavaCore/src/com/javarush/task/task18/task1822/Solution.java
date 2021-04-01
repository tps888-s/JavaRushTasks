package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();

        BufferedReader filereader  = new BufferedReader(new InputStreamReader(new FileInputStream(filename1)));

        ArrayList<String> s2 = new ArrayList<>();
        String str = null;
        while((str = filereader.readLine()) != null){
            s2.add(str);
        }
        /*byte[] b1 = new byte[file1.available()];
        file1.read(b1,0,file1.available());*/
        //file1.close();
        filereader.close();

        //String s1 = new String(b1,"UTF-8");
        //String[] s2 = s1.split("\r\n");


        /*for (String s3 : s2){
            System.out.print("z");
            System.out.print(s3);

        }*/


        for (int i = 0; i < s2.size(); i++) {


        if (s2.get(i).startsWith(args[0]+" ")) {
                        System.out.print(s2.get(i));

        }
        }

    }
}
