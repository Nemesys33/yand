package com.abrashkovvadim.springboot.yand.entity.courier;

import jakarta.persistence.Embeddable;

@Embeddable
public class Curier_wh {
    private String wh;

    public Curier_wh() {
    }

    public Curier_wh(String wh) {
        this.wh = wh;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh;
    }
}
