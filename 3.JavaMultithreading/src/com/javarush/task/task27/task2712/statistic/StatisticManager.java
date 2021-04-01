package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    private static StatisticManager statisticManager = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    private StatisticManager(){
        
    }

    public static StatisticManager getInstance(){

        return  statisticManager;
    }

    public void register(EventDataRow data){
        statisticStorage.put(data);
    }


    public TreeMap<String, Long> getVideoTotalAmount(){
        TreeMap<String, Long> resultMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 =formatter.parse(o1);
                    date2 =formatter.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date1.compareTo(date2)*-1;
            }
        });
        ArrayList<VideoSelectedEventDataRow> allVideoEvents = new ArrayList(statisticStorage.getStorage().get(EventType.SELECTED_VIDEOS));
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        for (VideoSelectedEventDataRow event : allVideoEvents){
            String key = format.format(event.getDate());
            if (resultMap.containsKey(key)) resultMap.put(key, resultMap.get(key) + event.getAmount());
                else resultMap.put(key, event.getAmount());
        }
        return resultMap;
    }


    public TreeMap<String, TreeMap<String, Long>> getCookWorkloading(){
        TreeMap<String, TreeMap<String, Long>> resultMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
                Date date1 = null;
                Date date2 = null;
                try {
                    date1 =formatter.parse(o1);
                    date2 =formatter.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return date1.compareTo(date2)*-1;
            }
        });
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        ArrayList<CookedOrderEventDataRow> allCookedEvents = new ArrayList(statisticStorage.getStorage().get(EventType.COOKED_ORDER));

        for (CookedOrderEventDataRow event : allCookedEvents){
            String key = format.format(event.getDate());
            if (resultMap.containsKey(key)) {
                TreeMap<String, Long>  oneDayCookMap = resultMap.get(key);
                long previousValue = oneDayCookMap.get(event.getCookName()) == null? 0:oneDayCookMap.get(event.getCookName());
                oneDayCookMap.put(event.getCookName(),previousValue + event.getTime());
                resultMap.put(key, oneDayCookMap);
            }
            else {
                TreeMap<String, Long> newOneDayCookMap = new TreeMap<>();
                newOneDayCookMap.put(event.getCookName(), (long)event.getTime());
                resultMap.put(key, newOneDayCookMap);
            }
        }

        return resultMap;
    }

     private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

         private StatisticStorage() {
             storage.put(EventType.COOKED_ORDER,new ArrayList<EventDataRow>());
             storage.put(EventType.SELECTED_VIDEOS,new ArrayList<EventDataRow>());
             storage.put(EventType.NO_AVAILABLE_VIDEO,new ArrayList<EventDataRow>());
         }

         private void put(EventDataRow data){
             for (Map.Entry<EventType, List<EventDataRow>> entry : storage.entrySet())
             {
                 if(entry.getKey().equals(data.getType())) entry.getValue().add(data);
             }

         }

         public Map<EventType, List<EventDataRow>> getStorage() {
             return storage;
         }
     }
}
