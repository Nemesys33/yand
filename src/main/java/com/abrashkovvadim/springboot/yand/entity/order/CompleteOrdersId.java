package com.abrashkovvadim.springboot.yand.entity.order;

import java.util.List;

public class CompleteOrdersId {
    private List<Integer> ids;

    public CompleteOrdersId() {
    }

    public CompleteOrdersId(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
