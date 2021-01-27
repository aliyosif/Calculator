package com.steven.model;

import java.util.*;

public class Order {

    private final Map<String, Integer> orderMap = new HashMap<>();
    private final List<OrderItem> itemList = new ArrayList<>();

    public List<OrderItem> getOrder() {
        return itemList;
    }

    public Map<String, Integer> mapOrder() {
        itemList.forEach(orderItem -> orderMap.put(orderItem.getType(), orderItem.getTarget()));
        return orderMap;
    }
}
