package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/
public class Solution {

    public static long[] getNumbers(long N) {
        int numberSize = String.valueOf(N).length();
        double[][] powArray = new double[10][numberSize];
        ArrayList<Long> list = new ArrayList<>();

        for (int z = 0; z <10; z++) {
            for (int y = 0; y < numberSize; y++) {
                powArray[z][y] = Math.pow(z, y + 1);
            }
        }

        for (Long x = 1L; x < N; x++){
            char[] chars = String.valueOf(x).toCharArray();
            int size = chars.length;
            double sum = 0;
            for (char ch : chars){
                sum = sum + powArray[Character.getNumericValue(ch)][size-1];
            }
            if (sum == x) list.add(x);
        }


        long[] result = new long[list.size()];
        for (int i =0; i <list.size(); i++ ){
            result[i] = list.get(i);
        }


        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Integer.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
