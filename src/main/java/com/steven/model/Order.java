package com.steven.model;

import lombok.Getter;

import java.util.*;

public class Order {

    private final Map<String, Integer> orderMap = new HashMap<>();
    @Getter private final List<OrderItem> order = new ArrayList<>();

    public Map<String, Integer> mapOrder() {
        order.forEach(orderItem -> orderMap.put(orderItem.getMediaType(), orderItem.getOrderNumber()));
        return orderMap;
    }
}
