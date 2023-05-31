package com.abrashkovvadim.springboot.yand.entity.order;

import java.util.List;

public class CompleteOrderList {

    private List<CompleteOrder> complete_info;

    public CompleteOrderList() {
    }

    public CompleteOrderList(List<CompleteOrder> completeOrderList) {
        this.complete_info = completeOrderList;
    }

    public List<CompleteOrder> getComplete_info() {
        return complete_info;
    }

    public void setComplete_info(List<CompleteOrder> complete_info) {
        this.complete_info = complete_info;
    }
}
