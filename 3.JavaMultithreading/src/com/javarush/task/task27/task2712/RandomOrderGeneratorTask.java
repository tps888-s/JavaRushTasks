package com.javarush.task.task27.task2712;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable{
    private List<Tablet> tablets;
    int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isInterrupted() == false) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {

            }
            tablets.get((int) (Math.round(Math.random() * (tablets.size()-1)))).createTestOrder();
        }
    }
}

