package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();

    }

    public static List<Dish> getAllDishesForOrder() throws IOException{
        List<Dish> dishList = new ArrayList<>();
        writeMessage(Dish.allDishesToString());
        writeMessage("Choose your dishes, input each choice, type \"exit\" to finish your order");

        while (true){
            String dishChoise = readString().toLowerCase();
            if (dishChoise.equals("exit")) break;
            if (!Dish.allDishesToString().toLowerCase().contains(dishChoise) && !dishChoise.equals("exit")) {
                writeMessage("This dish is not on the menu");
                continue;
            }
            else dishList.add(Dish.valueOf(dishChoise.substring(0,1).toUpperCase() + dishChoise.substring(1)));

        }
        return dishList;
    }
}
