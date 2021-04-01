package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static {
        //throw an exception here - выбросьте эксепшн тут
        int i=1;
        if (i==1)throw new ArithmeticException("11");
        else ;
    }

    public static int B = 5;

    public static void main(String[] args) {
        System.out.println(B);
    }
}
