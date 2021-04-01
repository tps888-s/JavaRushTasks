package com.javarush.task.task27.task2712.ad;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;
    ArrayList<Advertisement> listOfVideos = new ArrayList<>();
    int totalTime;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    private void recursiveMethod(int z) {
        for (int i = z + 1; i < storage.list().size(); i++) {

            if (!listOfVideos.contains(storage.list().get(i)) && totalTime + storage.list().get(i).getDuration() <= timeSeconds
                    && storage.list().get(i).getHits() > 0) {
                listOfVideos.add(storage.list().get(i));
                totalTime = totalTime + storage.list().get(i).getDuration();
                recursiveMethod(i);
            }
        }
    }

    public void processVideos() {
        //подобрать список видео
        Integer variant = 1;
        totalTime = 0;
        HashMap<Integer, ArrayList<Advertisement>> map = new HashMap<>();

        //перебираем все видео, составляем список вариантов подходящий по длине ролика
        for (int i = 0; i < storage.list().size(); i++) {

            if (!listOfVideos.contains(storage.list().get(i)) && storage.list().get(i).getDuration() <= timeSeconds && storage.list().get(i).getHits() > 0) {
                listOfVideos.add(storage.list().get(i));
                totalTime = totalTime + storage.list().get(i).getDuration();
                recursiveMethod(i);
            }
            if (listOfVideos.size() > 0) {
                ArrayList<Advertisement> listToMap = new ArrayList<>(listOfVideos);
                map.put(variant, listToMap);
                variant++;
                listOfVideos.clear();
                totalTime = 0;
            }

        }
        if (storage.list().size() < 1)
            throw new NoVideoAvailableException();

        //считаем показатели каждого варианта
        List<SelectionOfVideo> allVariants = new ArrayList<>();

        for (Map.Entry<Integer, ArrayList<Advertisement>> entry : map.entrySet()) {
            int variant1 = entry.getKey();
            int totalTime = 0;
            int countVideos = entry.getValue().size();
            long totalCost = 0;
            for (Advertisement ad : entry.getValue()) {
                totalTime = totalTime + ad.getDuration();
                totalCost = totalCost + ad.getAmountPerOneDisplaying();
            }
            allVariants.add(new SelectionOfVideo(variant1, totalTime, countVideos, totalCost, entry.getValue()));
        }
        //сортируем варианты
        Comparator<SelectionOfVideo> sortVideosVariants = new Comparator<SelectionOfVideo>() {
            @Override
            public int compare(SelectionOfVideo o1, SelectionOfVideo o2) {
                int x = 0;
                if (o1.totalCost > o2.totalCost) x = -1;
                else if (o1.totalCost < o2.totalCost) x = 1;
                else if (o1.totalCost == o2.totalCost) {
                    if (o1.totalTime > o2.totalTime) x = -1;
                    else if (o1.totalTime < o2.totalTime) x = 1;
                    else if (o1.totalTime == o2.totalTime) {
                        if (o1.countVideos < o2.countVideos) x = -1;
                        else if (o1.countVideos > o2.countVideos) x = 1;
                    }
                }
                return x;
            }
        };

        Collections.sort(allVariants, sortVideosVariants);
        //берем один подходящий вариант, его стоимость и продолжительность
        ArrayList<Advertisement> finalListOfVideos = allVariants.get(0).listofVideos;
        long amount = allVariants.get(0).totalCost;
        int totalDuration =  allVariants.get(0).totalTime;


        //сортируем результат перед выводом на экран
        Comparator<Advertisement> sortResultVideos = new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                int x = 0;
                if (o1.getAmountPerOneDisplaying() > o2.getAmountPerOneDisplaying()) x = -1;
                else if (o1.getAmountPerOneDisplaying() < o2.getAmountPerOneDisplaying()) x = 1;
                else if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()) {
                    if (o1.getAmountPerOneDisplaying() / o1.getDuration() > o2.getAmountPerOneDisplaying() / o2.getDuration())
                        x = 1;
                    else if (o1.getAmountPerOneDisplaying() / o1.getDuration() < o2.getAmountPerOneDisplaying() / o2.getDuration())
                        x = -1;
                }
                return x;
            }
        };
        Collections.sort(finalListOfVideos, sortResultVideos);

        //регистрируем событие для статистики
        StatisticManager statisticManager =  StatisticManager.getInstance();
        statisticManager.register(new VideoSelectedEventDataRow(finalListOfVideos,amount, totalDuration));

        //выводим видео в консоль
        for (Advertisement ad : finalListOfVideos) {
            ConsoleHelper.writeMessage(ad.getName() + " is displaying... " + ad.getAmountPerOneDisplaying() + ", " + ad.getAmountPerOneDisplaying() * 1000 / ad.getDuration());
            ad.revalidate();
        }

    }


    private class SelectionOfVideo {
        int variant;
        int totalTime;
        int countVideos;
        long totalCost;
        ArrayList<Advertisement> listofVideos;

        public SelectionOfVideo(int variant, int totalTime, int countVideos, long totalCost, ArrayList<Advertisement> listofVideos) {
            this.variant = variant;
            this.totalTime = totalTime;
            this.countVideos = countVideos;
            this.totalCost = totalCost;
            this.listofVideos = listofVideos;
        }
    }
}
