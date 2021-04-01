package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.ref.SoftReference;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String s : test.fullyQualifiedNames()) {
                System.out.println(s);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if(c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest test = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class s : test.value()) {
                System.out.println(s.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
