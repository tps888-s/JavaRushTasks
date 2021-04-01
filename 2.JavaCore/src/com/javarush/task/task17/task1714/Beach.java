package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private volatile String name;      //название
    private volatile float distance;   //расстояние
    private volatile int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }


    @Override
    public synchronized int compareTo(Beach o) {
        int x1 = (int) (this.getDistance()-o.getDistance());
        int x2 = this.getQuality()-o.getQuality();
        return x2-x1;
    }

    public static void main(String[] args) {


    }





}
