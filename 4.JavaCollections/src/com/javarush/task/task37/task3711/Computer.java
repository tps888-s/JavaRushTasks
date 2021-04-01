package com.javarush.task.task37.task3711;

public class Computer {
    CPU cpu;
    Memory ram;
    HardDrive hdd;

    public Computer() {
        this.cpu = new CPU();
        this.ram = new Memory();
        this.hdd = new HardDrive();
    }

    public void run() {
        cpu.calculate();
        ram.allocate();
        hdd.storeData();
    }
}
