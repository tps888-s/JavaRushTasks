package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws Exception{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String filename="";
    String filetowrite="";
    HashMap<String,BufferedInputStream> filelist = new HashMap<>();

    while (true){
        filename = reader.readLine();
        if (filename.equals("end")) {
            reader.close();
            break;
        }
        else {

            String[] s1 = filename.split("\\.");
            filelist.put(s1[2], new BufferedInputStream(new FileInputStream(filename)));
            filetowrite = s1[0]+"."+s1[1];
        }
    }
        ArrayList<String> filenames = new ArrayList<String>(filelist.keySet());
        Collections.sort(filenames);

        BufferedWriter writer = new BufferedWriter(new FileWriter(filetowrite));

        for (String s2 : filenames){
            byte[] b1 = new byte[filelist.get(s2).available()];
            filelist.get(s2).read(b1,0,filelist.get(s2).available());
            filelist.get(s2).close();
            String stringtowrite = new String(b1);
            writer.write(stringtowrite);
        }
        writer.close();


    }
}
