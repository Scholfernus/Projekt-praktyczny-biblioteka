package com.sda.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class DisplayUtil<T> {

    public Map<Integer,T> getItems(Collection<T> collection) {
        Map<Integer,T> items = new TreeMap<>();
        int index = 1;
        for(T item : collection){
            items.put(index, item);
            index++;
        }
        return items;
    }
}