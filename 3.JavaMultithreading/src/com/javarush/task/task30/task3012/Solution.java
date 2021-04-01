package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        System.out.println(-1.0/Double.POSITIVE_INFINITY);

        /*
        ArrayList<Integer> array = new ArrayList<>();
        int remainder;
        int rem = number;

        while (!(rem == 0)) {
            remainder = rem % 3;
            rem = rem / 3;
            if (remainder == 0) array.add(0);
            if (remainder == 1) array.add(1);
            if (remainder == 2) {
                array.add(-1);
                rem++ ;
            }
        }
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) !=0) {
                if (array.get(i) == 1)
                sb.append("+ " + (int) Math.pow(3, i) + " ");
                else sb.append("- " + (int) Math.pow(3, i) + " ");
            }
        }
        System.out.println(number + " = " + sb.toString().trim());

         */
    }
}