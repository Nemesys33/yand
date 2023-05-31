package com.abrashkovvadim.springboot.yand.entity.order;

import java.util.List;

public class OrderList {
    private List<Order> orders;

    public OrderList() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
