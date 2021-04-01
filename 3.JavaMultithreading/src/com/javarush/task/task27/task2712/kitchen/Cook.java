package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable {
    private String name;
    private boolean busy;
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }


    public void startCookingOrder(Order order){
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString() + ", cooking time " + order.getTotalCookingTime() + "min");
        setChanged();

        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {

        }

        notifyObservers(order);
        StatisticManager statisticManager =  StatisticManager.getInstance();
        statisticManager.register(new CookedOrderEventDataRow(this.toString(),name, order.getTotalCookingTime()*60, ((Order) order).dishes));
        busy = false;
    }

    @Override
    public void run() {
        while (true){
            if (queue.size()>0){
                 if (!isBusy()){
                        startCookingOrder(queue.poll());
                    }

            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
