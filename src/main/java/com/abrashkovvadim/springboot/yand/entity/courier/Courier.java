package com.abrashkovvadim.springboot.yand.entity.courier;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "couriers_abr")
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "courier_type")
    @Enumerated(EnumType.STRING)
    private Courier_type courier_type;

    @JsonProperty("working_hours")
    @ElementCollection
    @CollectionTable(name = "curier_wh_abr", joinColumns = @JoinColumn(name = "courier_id"))
    @Column(name = "wh")
    private List<String> working_hours;

    @JsonProperty("regions")
    @ElementCollection
    @CollectionTable(name = "curier_region_abr", joinColumns = @JoinColumn(name = "courier_id"))
    @Column(name = "region")
    private List<Integer> regions;

    public Courier() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Courier_type getCourier_type() {
        return courier_type;
    }

    public void setCourier_type(Courier_type courier_type) {
        this.courier_type = courier_type;
    }

    public List<String> getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(List<String> working_hours) {
        this.working_hours = working_hours;
    }

    public List<Integer> getRegions() {
        return regions;
    }

    public void setRegions(List<Integer> regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "id=" + id +
                ", type=" + courier_type +
                ", regions=" + regions +
                ", working_hours=" + working_hours +
                '}';
    }
}
