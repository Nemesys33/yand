package com.abrashkovvadim.springboot.yand.entity.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders_abr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cost")
    private int cost;

    @Column(name = "regions")
    private int regions;

    @Column(name = "weight")
    private float weight;

    @JsonProperty("delivery_hours")
    @ElementCollection
    @CollectionTable(name = "order_delivery_time_abr", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "deliv_time")
    private List<String> delivery_hours;

    @Column(name = "completed")
    private boolean completed = false;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRegions() {
        return regions;
    }

    public void setRegions(int regions) {
        this.regions = regions;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public List<String> getDelivery_hours() {
        return delivery_hours;
    }

    public void setDelivery_hours(List<String> delivery_hours) {
        this.delivery_hours = delivery_hours;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cost=" + cost +
                ", regions=" + regions +
                ", weight=" + weight +
                ", delivery_hours=" + delivery_hours +
                '}';
    }
}
