package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int s,d,e;
        s=number/100;
        d=(number-s*100)/10;
        e=number-s*100-d*10;
        int summa = s+d+e;
        return summa;
    }
}