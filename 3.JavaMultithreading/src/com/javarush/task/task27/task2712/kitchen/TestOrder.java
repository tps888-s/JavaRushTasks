package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;

public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    @Override
    protected void initDishes() throws IOException {
        int randomCount = Math.round(Dish.values().length);
        ArrayList<Dish> dishesList = new ArrayList<>();
        Dish[] dishes = Dish.values();
        for (int i = 0; i < randomCount; i++){
            dishesList.add(dishes[(int)(Math.random()*(Dish.values().length-1))]);
        }
        super.dishes = dishesList;
    }
}
