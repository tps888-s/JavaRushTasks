package com.javarush.task.task15.task1522;

public class rr {
    private static rr ourInstance = new rr();

    public static rr getInstance() {
        return ourInstance;
    }

    private rr() {
    }
}
