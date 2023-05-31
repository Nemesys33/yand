package com.abrashkovvadim.springboot.yand.entity.courier;

public class CourierMetaInfo {

    private long income;
    private double rating;

    public CourierMetaInfo() {
    }

    public CourierMetaInfo(long income, double rating) {
        this.income = income;
        this.rating = rating;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CourierMetaInfo{" +
                "income=" + income +
                ", rating=" + rating +
                '}';
    }
}
