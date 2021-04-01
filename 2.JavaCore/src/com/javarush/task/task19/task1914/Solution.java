package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream b_array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(b_array);

        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String[] s = b_array.toString().split(" ");

        int x1 = Integer.parseInt(s[0]);
        String up = s[1];
        int x2 = Integer.parseInt(s[2]);
        int result=0;

        if (up.equals("+")) result=x1+x2;
        if (up.equals("-")) result=x1-x2;
        if (up.equals("*")) result=x1*x2;

        System.out.print(x1);
        System.out.print(" ");
        System.out.print(up);
        System.out.print(" ");
        System.out.print(x2);
        System.out.print(" = ");
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

