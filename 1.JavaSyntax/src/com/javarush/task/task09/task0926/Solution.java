package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<int[]>();
        int [] a1 ={5,4,3,2,1};
        int [] a2 ={2,1};
        int [] a3 ={4,3,2,1};
        int [] a4 ={7,6,5,4,3,2,1};
        int [] a5 ={};

        list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(a5);
        return list;


    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
