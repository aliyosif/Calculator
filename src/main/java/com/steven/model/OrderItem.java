package com.steven.model;

import lombok.Getter;

public class OrderItem {

    @Getter private final int orderNumber;
    @Getter private final String mediaType;

    public OrderItem(int orderNumber, String mediaType) {
        this.orderNumber = orderNumber;
        this.mediaType = mediaType;
    }

    public String toString() {
        return orderNumber + " " + mediaType;
    }
}
