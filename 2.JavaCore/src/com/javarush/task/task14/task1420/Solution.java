package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            int a = Integer.parseInt(r.readLine());
            int b =Integer.parseInt(r.readLine());
            if (a<=0 || b<=0) throw new Exception();
            ArrayList<Integer> list = new ArrayList<>();
            int x;
            if (a>b) x =a;
            else x=b;

                for (int i =1; i<=x; i++){
                    if(a%i==0 && b%i==0) list.add(0,i);
                }
                System.out.print(list.get(0));


    }
}
