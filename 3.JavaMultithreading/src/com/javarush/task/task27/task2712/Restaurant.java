package com.javarush.task.task27.task2712;


import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en", "US"));

        //Создаем поваров и запускаем нити
        Cook cook1 = new Cook("Cook");
        cook1.setQueue(orderQueue);
        Cook cook2 = new Cook("Cook2");
        cook2.setQueue(orderQueue);
        Thread threadCook1 = new Thread(cook1);
        threadCook1.start();
        Thread threadCook2 = new Thread(cook2);
        threadCook2.start();

        //Создаем и добавляем официантов
        cook1.addObserver(new Waiter());
        cook2.addObserver(new Waiter());

        //Создаем планшеты
        ArrayList<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i <5; i++){
            tablets.add(new Tablet(i));
            tablets.get(i).setQueue(orderQueue);
        }


        //создаем и запускаем таск
        RandomOrderGeneratorTask task1 = new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL);
        Thread thread1 = new Thread(task1);
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.interrupt();


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();

    }
}


