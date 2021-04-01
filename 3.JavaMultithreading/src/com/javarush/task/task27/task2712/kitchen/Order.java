package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();

    }

    protected void initDishes() throws IOException{
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes.size() < 1) return "";
        else {
            StringBuilder sb = new StringBuilder();
            for (Dish d : dishes) {
                sb.append(d.toString());
                sb.append(", ");
            }
            String dishes = sb.toString();

            return "Your order:[" + dishes.substring(0, dishes.length() - 2) + "] of " + tablet.toString();
        }
    }

    public int getTotalCookingTime(){
        int totalTime = 0;

        for (Dish d : dishes){
            totalTime = totalTime + d.getDuration();
        }
        return totalTime;
    }

    public boolean isEmpty(){
        return dishes.size()<1;
    }
}
