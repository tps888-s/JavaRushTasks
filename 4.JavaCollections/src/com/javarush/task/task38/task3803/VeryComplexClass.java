package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
       Object s = "null";

        Integer s1 = (Integer) s;

    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.contains("a");

    }

    public static void main(String[] args) {

    }
}
