package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static synchronized void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        private final AtomicInteger thread_num = new AtomicInteger(1);
        private static final AtomicInteger factory_num = new AtomicInteger(0);

        public AmigoThreadFactory(){
            factory_num.getAndIncrement();
        }


        @Override
        public Thread newThread(Runnable r) {
            StringBuilder thread_name = new StringBuilder();
            //group name
            thread_name.append(Thread.currentThread().getThreadGroup().getName());
            thread_name.append("-pool-");
            thread_name.append(factory_num);
            thread_name.append("-thread-");
            thread_name.append(thread_num.getAndIncrement());

            Thread t =new Thread(r,thread_name.toString());

            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);

            return t;
        }
    }


}
