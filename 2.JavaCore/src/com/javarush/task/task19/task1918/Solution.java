package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        String line = "";
        String data = "";
        BufferedReader r = new BufferedReader(new FileReader(file));
        while((line = r.readLine())!=null) {
            data = data + line;
        }

        r.close();

        String tag = args[0];
        Pattern pattern_s = Pattern.compile("<"+ tag);
        Pattern pattern_e = Pattern.compile("</"+ tag +">");

        Matcher s = pattern_s.matcher(data);
        Matcher e = pattern_e.matcher(data);

        ArrayList<Integer> s_arr = new ArrayList<>();
        ArrayList<Integer> e_arr = new ArrayList<>();

        while(s.find()){
            s_arr.add(s.start());
        }

        while(e.find()){
            e_arr.add(e.start());
        }



        for (int i =0 ; i < s_arr.size()-1; i++){

            if (e_arr.get(i)>s_arr.get(i+1)) {
                e_arr.add(i,e_arr.get(i+1));
                e_arr.remove(i+2);
            }
        }
        for (int i =0 ; i < s_arr.size(); i++) {
            System.out.println(data.substring(s_arr.get(i), e_arr.get(i) + tag.length()+3));
        }

    }
}
