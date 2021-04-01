package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("F1","I1");
        map.put("F2","I2");
        map.put("F1","I3");
        map.put("F4","I3");
        map.put("F5","I4");
        map.put("F5","I5");
        map.put("F6","I6");
        map.put("F7","I7");
        map.put("F8","I7");
        map.put("F9","I8");
        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
