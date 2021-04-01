package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<String> list = new ArrayList<>();
        list.add(e.getClass() + ": " + e.getMessage());
        Throwable next = e.getCause();

        while (true){
            if (next == null) break;
            else list.add(next.getClass() + ": " + next.getMessage());
            next = next.getCause();
        }


        for (int i = list.size()-1; i >= 0; i--){
            System.out.println(list.get(i).replace("class ", ""));
        }


   }

    public static void main(String[] args) {

        try {
            //throw new Exception("ABC");
            throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        }
        catch (Exception e){
            new Solution().uncaughtException(Thread.currentThread(), e);
        }


    }
}
