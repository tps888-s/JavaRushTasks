package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
            String a =  e.getClass().getSimpleName();
            if (a.contains("Error")) System.out.println("Нельзя дальше работать");
            if (a.contains("Exception")) System.out.println("Надо обработать");
            if (a.contains("Throwable")) System.out.println("Поживем - увидим");

            }
        });



    }

    public void test() {
     // int a =  3/0;
      String b1 = "b1";
      String b2 = "";
      String b3 = b1 + b2.substring(2);

    };

    public static void main(String[] args) {
        Solution a = new Solution();

        a.test();

    }
}
