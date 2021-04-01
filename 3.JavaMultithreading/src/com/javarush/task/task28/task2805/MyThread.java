package com.javarush.task.task28.task2805;

public class MyThread extends Thread{
    private static int priority_count=0;

    {
        if (priority_count==10) priority_count=0;

    }

    public MyThread() {
        setPriority(++priority_count);
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority(++priority_count);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority(++priority_count);
    }

    public MyThread(String name) {
        super(name);
        setPriority(++priority_count);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority(++priority_count);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority(++priority_count);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority(++priority_count);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority(++priority_count);
    }

    /*
    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals) {
        super(group, target, name, stackSize, inheritThreadLocals);
        if (priority_count==10) priority_count=0;
        setPriority(++priority_count);
    }

     */




}
