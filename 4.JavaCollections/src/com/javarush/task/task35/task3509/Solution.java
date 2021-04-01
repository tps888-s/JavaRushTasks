package com.javarush.task.task35.task3509;

import java.lang.reflect.Type;
import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        //напишите тут ваш код
        ArrayList<T> list = new ArrayList<>();
        for (T o : elements){
            list.add((T) o);
        }

        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
        HashSet<T> set = new HashSet<>();
        for (T o : elements){
            set.add((T) o);
        }
        return set;
    }

    public static <K,V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        //напишите тут ваш код
        HashMap<K, V> map = new HashMap<>();
        if (keys.size() == values.size()){
            for (int i = 0; i < keys.size(); i++){
                map.put(keys.get(i), values.get(i));
            }
        }
        else throw new IllegalArgumentException();

        return map;
    }
}
