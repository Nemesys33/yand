package com.abrashkovvadim.springboot.yand.entity.courier;

import jakarta.persistence.Embeddable;

@Embeddable
public class Curier_region {
    private int region;

    public Curier_region() {
    }

    public Curier_region(int region) {
        this.region = region;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }
}
