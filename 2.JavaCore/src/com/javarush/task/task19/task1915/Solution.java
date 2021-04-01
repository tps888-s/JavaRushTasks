package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream console = System.out;

        ByteArrayOutputStream b_array = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(b_array);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(console);

        System.out.println(b_array.toString());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        reader.close();

        FileOutputStream w = new FileOutputStream(file1);
        w.write(b_array.toByteArray());
        w.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

