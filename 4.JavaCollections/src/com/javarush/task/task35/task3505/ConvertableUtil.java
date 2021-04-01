package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable> Map<K, V> convert(List<V> list) {
        Map result = new HashMap();

        for (V v : list){
            result.put(v.getKey(), v);
        }

        return result;
    }
}
