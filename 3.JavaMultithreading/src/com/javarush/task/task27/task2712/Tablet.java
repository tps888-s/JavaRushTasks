package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    private final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Tablet(int number) {
        this.number = number;
    }

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        orderProcessing(order);

        return order;
    }

    public void createTestOrder() {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        orderProcessing(order);
    }

    private void orderProcessing(Order order) {
        ConsoleHelper.writeMessage(order.toString());

        if (order.getTotalCookingTime() > 0) {
            queue.add(order);
        }

        try {
            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        } catch (Exception e) {
            logger.log(Level.INFO, "No video is available for the order " + order.toString());
        }
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
