package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager statisticAdvertisementManager = new StatisticAdvertisementManager();
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return statisticAdvertisementManager;
    }

    public ArrayList<Advertisement> getActiveVideoSet(){
        ArrayList<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : advertisementStorage.list()){
            if (ad.getHits() > 0 )resultList.add(ad);
        }
        resultList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return resultList;
    }

    public ArrayList<Advertisement> getArchiveVideoSet(){
        ArrayList<Advertisement> resultList = new ArrayList<>();

        for (Advertisement ad : advertisementStorage.list()){
            if (ad.getHits() == 0 )resultList.add(ad);
        }
        resultList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return resultList;
    }
}

