package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    public void printAdvertisementProfit() {

        TreeMap<String, Long> resultMap = StatisticManager.getInstance().getVideoTotalAmount();
        double total = 0;


        for (Map.Entry<String, Long> entry : resultMap.entrySet()) {
           if(entry.getValue() > 0) {

               double value = entry.getValue()/100.0;
               BigDecimal bd = new BigDecimal(Double.toString(value));
               bd = bd.setScale(2);
               total = total + value;
               ConsoleHelper.writeMessage(entry.getKey() + " - " + bd);
           }
        }
        if (total > 0) {
            BigDecimal bd2 = new BigDecimal(Double.toString(total));
            bd2 = bd2.setScale(2);
            ConsoleHelper.writeMessage("Total - " + bd2);
        }

    }

    public void printCookWorkloading() {
        TreeMap<String, TreeMap<String, Long>> resultMap = StatisticManager.getInstance().getCookWorkloading();

        for (Map.Entry<String, TreeMap<String, Long>> entry : resultMap.entrySet()) {

            ConsoleHelper.writeMessage(entry.getKey());
            for (Map.Entry<String, Long> entry2 : entry.getValue().entrySet()) {
                if (entry2.getValue() > 0)
                ConsoleHelper.writeMessage(entry2.getKey() + " - " + Math.round(Math.ceil(entry2.getValue() / 60)) + " min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() {
        ArrayList<Advertisement> resultList = StatisticAdvertisementManager.getInstance().getActiveVideoSet();

        for (Advertisement ad : resultList){
            ConsoleHelper.writeMessage(ad.getName() + " - " + ad.getHits());
        }

    }

    public void printArchivedVideoSet() {
        ArrayList<Advertisement> resultList = StatisticAdvertisementManager.getInstance().getArchiveVideoSet();

        for (Advertisement ad : resultList){
            ConsoleHelper.writeMessage(ad.getName());
        }
    }
}
