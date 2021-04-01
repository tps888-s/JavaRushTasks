package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator{
    private Thread thread;

    @Override
    public void run() {

        while (!this.thread.isInterrupted()) {
            System.out.println(thread.getName());
            try {
                Thread.sleep(100);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void start(String threadName) {

        this.thread = new Thread(this,threadName);
        thread.start();
    }

    @Override
    public void stop() {
    thread.interrupt();
    }
}
