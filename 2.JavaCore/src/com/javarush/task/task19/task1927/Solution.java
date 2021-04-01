package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream =    new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(console);

        String s = outputStream.toString();
        String[] s_arr = s.split("\\n");
        String snew = "";
        int count = 0;

        for (String sl : s_arr){
            count++;
            if (count%2==0) snew= snew + sl + System.lineSeparator() + "JavaRush - курсы Java онлайн" + System.lineSeparator();
            else snew= snew + sl + System.lineSeparator();
        }

        System.out.println(snew);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
