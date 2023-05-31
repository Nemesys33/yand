package com.abrashkovvadim.springboot.yand.entity.courier;

import java.util.List;

public class CourierList {
    private List<Courier> couriers;

    public CourierList() {
    }

    public List<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(List<Courier> couriers) {
        this.couriers = couriers;
    }
}
