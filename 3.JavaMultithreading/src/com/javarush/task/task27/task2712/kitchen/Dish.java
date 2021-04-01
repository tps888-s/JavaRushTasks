package com.javarush.task.task27.task2712.kitchen;

 public enum Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

     private int duration;

     Dish(int i) {
         duration = i;
     }

     public int getDuration() {
         return duration;
     }

     public static String allDishesToString(){
         StringBuilder sb  = new StringBuilder();
         for (Dish d : Dish.values()) {
             sb.append(d.toString());
             sb.append(", ");
         }
         String dishes = sb.toString();
        return dishes.substring(0,dishes.length()-2);
     }
}
