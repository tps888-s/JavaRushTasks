package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
 static {
     threads.add(new Th1());
     threads.add(new Th2());
     threads.add(new Th3());
     threads.add(new Th4());
     threads.add(new Th5());
 }
    public static void main(String[] args) {

    }

    public static class Th1 extends Thread{
        @Override
        public void run() {
            while (true){}
        }
    }

    public static class Th2 extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(500);}
            catch (Exception e) {System.out.println("InterruptedException");}
        }
    }

    public static class Th3 extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("Ура");
                try{
                Thread.sleep(500);}
                catch (Exception e) {}
            }
        }
    }

    public static class Th4 extends Thread implements Message{
     public static boolean bl=true;
        @Override
        public void run() {
            while (bl){

            }
        }

        @Override
        public void showWarning() {
            bl=false;
        }
    }

    public static class Th5 extends Thread{
        @Override
        public void run() {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            Integer s = 0;

            while (true){
                try{
                    String s1 = r.readLine();
                    if (s1=="N") break;
                    s= s+ Integer.parseInt(s1);}

                catch (Exception e) {}
                System.out.println(s);
            }
        }
    }
}