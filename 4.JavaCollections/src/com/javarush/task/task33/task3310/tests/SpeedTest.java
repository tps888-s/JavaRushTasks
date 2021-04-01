package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {


    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids){

        //замеряем время и добавляем id в сет
        Date dateStart = new Date();
        for (String s : strings) {
            ids.add(shortener.getId(s));
        }
        Date dateFinish = new Date();

        return dateFinish.getTime()-dateStart.getTime();
    }

    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings){

        //замеряем время и добавляем string в сет
        Date dateStart = new Date();
        for (long l : ids) {
            strings.add(shortener.getString(l));
        }
        Date dateFinish = new Date();

        return dateFinish.getTime()-dateStart.getTime();
    }




    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            String generatedString = Helper.generateRandomString();
            origStrings.add(generatedString);
        }

        Long time1 = getTimeToGetIds(shortener1, origStrings, new HashSet<>());
        Long time2 = getTimeToGetIds(shortener2, origStrings, new HashSet<>());

        Assert.assertTrue(time1 > time2);

        Set<Long> origIds = new HashSet<>();
        for (String s : origStrings) {
            origIds.add(shortener2.getId(s));
        }

        time1 = getTimeToGetStrings(shortener1, origIds, new HashSet<>());
        time2 = getTimeToGetStrings(shortener2, origIds, new HashSet<>());

        Assert.assertEquals(time1, time2, 30);

    }
}
