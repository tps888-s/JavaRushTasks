package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

        /*
        Integer[] array = {1, 2, 3, 4, 5};

        for (Integer i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");

        sort(array);

        for (Integer i : array) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("");

         */

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int array_len = array.length;
        int med;
        if (array_len %2 != 0) med = array[array_len/2];
        else med = (array[array_len/2-1]+array[array_len/2])/2;

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Math.abs(med-o1)-Math.abs(med-o2);
             }
        };

        Arrays.sort(array, comparator);

        return array;
    }
}
