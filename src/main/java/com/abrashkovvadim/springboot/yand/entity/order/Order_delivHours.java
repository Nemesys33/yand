package com.abrashkovvadim.springboot.yand.entity.order;

import jakarta.persistence.Embeddable;

@Embeddable
public class Order_delivHours {
    private String deliv_hours;

    public Order_delivHours() {
    }

    public Order_delivHours(String deliv_hours) {
        this.deliv_hours = deliv_hours;
    }

    public String getDeliv_hours() {
        return deliv_hours;
    }

    public void setDeliv_hours(String deliv_hours) {
        this.deliv_hours = deliv_hours;
    }
}
