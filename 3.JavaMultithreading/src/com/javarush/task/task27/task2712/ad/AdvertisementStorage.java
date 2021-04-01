package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage(){

        Object someContent = new Object();

        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 1, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 1, 10 * 60)); //10 min
        add(new Advertisement(someContent, "Четвертое видео", 200, 1, 2 * 60)); //2 min

/*
        add(new Advertisement(someContent, "First Video", 100, 1, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 1, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 100, 1, 10 * 60)); //10 min
        add(new Advertisement(someContent, "Fourth Video", 100, 1, 2 * 60)); //2 min
*/
    }

    public static AdvertisementStorage getInstance(){
                
        return  advertisementStorage;
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }

}
