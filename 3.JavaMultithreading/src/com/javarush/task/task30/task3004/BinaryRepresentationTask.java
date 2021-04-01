package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        String s1 = "";
        RecursiveTask s = null;
        if (b > 0) {
            s = new BinaryRepresentationTask(b);
            s.fork();
            s1 = (String)s.join();
        }

        return s1 + result;
    }
}
