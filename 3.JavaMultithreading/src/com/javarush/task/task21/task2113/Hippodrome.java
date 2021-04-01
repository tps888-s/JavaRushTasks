package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move(){
        for (Horse h : horses) {
            h.move();
        }
    }

    public void run(){

        for (int i = 0; i < 100; i++){
            move();
            print();
            try{
            Thread.sleep(200);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){

        HashMap<Double, Horse> horse_distance = new HashMap<>();
        ArrayList<Double> distance_list = new ArrayList<>();
        for (Horse h : horses){
            horse_distance.put(h.distance,h);
            distance_list.add(h.distance);
        }
        Collections.sort(distance_list);
        Double max_distance = distance_list.get(distance_list.size()-1);
        return horse_distance.get(max_distance);
        }

    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }


    public static void main(String[] args) {

        Hippodrome.game = new Hippodrome(new LinkedList<>());
        game.horses.add(new Horse("Horse1", 3.0,0.0));
        game.horses.add(new Horse("Horse2", 3.0,0.0));
        game.horses.add(new Horse("Horse3", 3.0,0.0));

        game.run();

        game.printWinner();

    }
}
