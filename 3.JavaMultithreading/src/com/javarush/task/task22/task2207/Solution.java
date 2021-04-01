package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder(" ");
        try(
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine()), "UTF8"));
        )
        {
            String line;
            while ((line = r.readLine()) != null)
            {
                sb.append(line.trim()+" ");
            }

        }

        //System.out.println(sb);

        String[] words = sb.toString().split(" ");
        List<String> w_list = Arrays.asList(words);
        ArrayList<String> words_list = new ArrayList<>();
        for(String s : w_list){
            words_list.add(s);
        }
        ArrayList<String> list = new ArrayList<>();
        int x =0;
        for (String w : words_list){

            for (int i = x; i<words_list.size()-1; i++){
                 String z = new StringBuilder(words_list.get(i+1)).reverse().toString();
                //System.out.print(w+"=");
                //System.out.print(words_list.get(i+1));
                //System.out.println("");
                 if (w.equals(z) && !list.contains(w) && !w.equals("")) {
                     list.add(w);
                     list.add(words_list.get(i+1));
                 }

            }
            x++;
        }

        for (int z = 0; z<list.size(); z=z+2){
            Pair p = new Pair();
            p.first=list.get(z);
            p.second=list.get(z+1);
            result.add(p);
        }

        for(Pair p : result){
            System.out.print(p.first+" ");
            System.out.print(p.second);
            System.out.println("");
        }



    }

    public static class Pair {
        String first;
        String second;

        protected Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
