package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread currentThread = Thread.currentThread();
            Integer i = 1;
            String s;
            while (!currentThread.isInterrupted()) {
                s = i.toString();
                map.put(s, "Some text for " + s);
                i++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+" thread was terminated");

        }

    }
}
