package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
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

        byte[] b = b_array.toByteArray();

        for (byte bt : b){
            if (bt>=48 && bt<=57) System.out.print((char)bt);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
