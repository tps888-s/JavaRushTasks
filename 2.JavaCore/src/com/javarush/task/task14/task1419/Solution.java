package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 2
            int[] a = new int[2];
            int b =a[3];

        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 3
            String s = "asd";
            int a = Integer.parseInt(s);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 4
            throw new NullPointerException("Exception: s is null!");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 5
            throw new ArrayStoreException("Exception 5");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 6
            throw new ClassCastException ("Exception 6");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 7
            throw new IndexOutOfBoundsException("Exception 7");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 8
            throw new NegativeArraySizeException ("Exception 8");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 9
            throw new StringIndexOutOfBoundsException ("Exception 9");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try { // 10
            throw new Exception("Exception 10");
        } catch (Exception e) {
            exceptions.add(e);
        }





        //напишите тут ваш код

    }
}
