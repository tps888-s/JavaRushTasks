package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listmain = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();



        for(int i = 0 ; i<20 ; i++){
            String s = reader.readLine();
            int x = Integer.parseInt(s);
            listmain.add(x);

            if (x%3 == 0) list3.add(x);
            if (x%2 == 0) list2.add(x);
            if (x%3!=0 && x%2!=0) list1.add(x);
        }
        printList(list3);
        printList(list2);
        printList(list1);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i =0; i<list.size(); i++){
            System.out.println(list.get(i));}
    }
}
