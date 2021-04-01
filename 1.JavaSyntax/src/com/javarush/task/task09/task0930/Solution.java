package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        Arrays.sort(array);
        ArrayList<String > list1 = new ArrayList<>();
        ArrayList<String > list2 = new ArrayList<>();
        for (String s : array){
            if (isNumber(s)) list1.add(s);
            else list2.add(s);
        }
        String[] array1 = list1.toArray(new String[0]);
        int [] array2 = Arrays.stream(array1).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array2);
        list1.clear();
        for (int i=0; i<array2.length; i++){
            list1.add(0,Integer.toString(array2[i]));
        }

        for (String s : list1) {
            list2.add(s);
        }
        for (int i=0; i<array.length; i++){
            array[i]=list2.get(i);
        }
        String a="";
        String b="";
        isGreaterThan(a,b);

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
