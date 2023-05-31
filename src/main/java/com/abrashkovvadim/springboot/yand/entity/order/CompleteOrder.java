package com.abrashkovvadim.springboot.yand.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "complete_order_abr")
public class CompleteOrder {

    @Id
    @Column(name = "order_id")
    private int order_id;

    @Column(name = "courier_id")
    private int courier_id;

    @Column(name = "complete_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,
            pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="UTC+3")
    private Date complete_time;

    public CompleteOrder() {
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public Date getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Date complete_time) {
        this.complete_time = complete_time;
    }

    @Override
    public String toString() {
        return "CompleteOrder{" +
                "order_id=" + order_id +
                ", courier_id=" + courier_id +
                ", complete_time=" + complete_time +
                '}';
    }
}
