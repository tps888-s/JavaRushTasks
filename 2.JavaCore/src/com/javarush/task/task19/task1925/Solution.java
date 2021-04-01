package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader r = new BufferedReader(new FileReader(args[0]));
        String filedata = "";
        while (true){
            String s1 = r.readLine();
            if(s1==null) break;
            filedata = filedata+s1+" ";
        }
        r.close();
        filedata.trim();

        String newfiledata = "";
        String[] words = filedata.split(" ");

        for (String w : words){
            if(w.length()>6) newfiledata = newfiledata + w + ",";
        }
        newfiledata = newfiledata.substring(0,newfiledata.length()-1);

        //System.out.println(newfiledata);
        FileWriter w = new FileWriter(args[1]);
        w.write(newfiledata);
        w.close();

    }
}
