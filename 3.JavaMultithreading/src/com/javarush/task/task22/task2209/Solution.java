package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try {

            try (
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));
            ) {
                String line;

                while((line=read.readLine()) != null){
                    sb.append(line+" ");
                }
            }
        }
            catch (IOException e) {
                e.printStackTrace();
            }

        String[] words = sb.toString().split(" ");

            StringBuilder result = getLine(words);
            System.out.println(result.toString());

        }
            public static StringBuilder getLine (String...words){
                ArrayList<String> list = new ArrayList<>();
                int words_size = words.length;

                for (int i1=0;i1<words_size;i1++){
                   list.add(words[i1]);

                   for (int i2=0; i2<words_size;i2++){


                   for (String s2 : words) {
                           if (!list.get(list.size() - 1).equals(s2) && s2.substring(0, 1).equalsIgnoreCase(list.get(list.size() - 1).substring(list.get(list.size() - 1).length() - 1)) && !list.contains(s2)) {
                               list.add(s2);
                           }
                       }
                   }

                    if (list.size()==words_size) break;
                    else list.clear();

                }

                StringBuilder sb = new StringBuilder("");
                for (String s : list){
                        sb.append(s+" ");

                }

                sb = new StringBuilder(sb.toString().trim());

                return sb;
            }

    }
