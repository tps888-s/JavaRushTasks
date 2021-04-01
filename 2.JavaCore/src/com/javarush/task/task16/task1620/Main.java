package com.javarush.task.task16.task1620;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            MyFirstThread thread = new MyFirstThread();
            thread.start();
        }
    }


    public static class MyFirstThread extends Thread {

        @Override
        public void run() {
            System.out.println("I'm Thread! My name is " + getName());
        }
    }
}