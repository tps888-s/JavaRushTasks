package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();

        for (String s : strings){
            set.add(shortener.getId(s));
        }

        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();

        for (Long l : keys){
            set.add(shortener.getString(l));
        }

        return set;

    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        //создаем переменные
        Set<Long> idSet = new HashSet<>();
        Set<String> stringSet = new HashSet<>();
        Set<String> generatedStringSet = new HashSet<>();
        Shortener shortener = new Shortener(strategy);

        //выводим имя стратегии
        Helper.printMessage(strategy.getClass().getSimpleName());

        //генрим множество строк
        for (int i = 0; i < elementsNumber; i++) {
            String generatedString = Helper.generateRandomString();
            generatedStringSet.add(generatedString);

        }
        //замеряем время и генерим строки
        Date dateStart = new Date();
        idSet= getIds(shortener,generatedStringSet);
        Date dateFinish = new Date();

        //выводим время в милисекундах
        Helper.printMessage(dateFinish.getTime()-dateStart.getTime() + " ms - result for getId method");

        //замеряем время и получаем множество строк
        dateStart = new Date();
        stringSet = getStrings(shortener,idSet);
        dateFinish = new Date();

        //выводим время в милисекундах
        Helper.printMessage(dateFinish.getTime()-dateStart.getTime() + " ms - result for getString method");


        //сравниваем множества
        if (generatedStringSet.equals(stringSet))
                Helper.printMessage("Тест пройден.");
            else Helper.printMessage("Тест не пройден.");
        }

    public static void main(String[] args) {
        testStrategy(new HashMapStorageStrategy(),10000);
        testStrategy(new OurHashMapStorageStrategy(),10000);
        testStrategy(new FileStorageStrategy(),100);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new DualHashBidiMapStorageStrategy(),10000);

    }
}
