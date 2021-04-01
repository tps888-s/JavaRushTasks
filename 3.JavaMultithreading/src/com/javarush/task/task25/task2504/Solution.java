package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread th : threads){
            switch (th.getState()) {
                case NEW: th.start(); break;
                case WAITING: th.interrupt(); break;
                case TIMED_WAITING: th.interrupt(); break;
                case BLOCKED: th.interrupt(); break;
                case RUNNABLE: th.isInterrupted(); break;
                case TERMINATED: System.out.println(th.getPriority()); break;

            }
        }

    }



    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[4];

        threads[0] = new Thread();
        System.out.println(threads[0].getState());

        threads[1] = new Thread();
        threads[1].start();
        //threads[1].wait();
        System.out.println(threads[1].getState());

        threads[2] = new Thread();
        threads[2].start();

        threads[3] = new Thread();
        threads[3].start();
        threads[3].interrupt();
        System.out.println(threads[3].getState());

        processThreads(threads);
    }
}
