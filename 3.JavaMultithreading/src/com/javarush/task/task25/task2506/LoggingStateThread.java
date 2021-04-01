package com.javarush.task.task25.task2506;

import static java.lang.Thread.State.TERMINATED;

public class LoggingStateThread extends Thread {
    private Thread target;

    @Override
    public void run() {
        State st = target.getState();
        System.out.println(st);
        while (!isInterrupted()) {

            if (st != target.getState()){
                st= target.getState();
                System.out.println(st);
            }
            if (st == TERMINATED) interrupt();
        }
    }

    public LoggingStateThread(Thread target) {
        this.target = target;

    }


}
