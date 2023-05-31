package com.abrashkovvadim.springboot.yand.dao.courierDAO;

import com.abrashkovvadim.springboot.yand.entity.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CourierDao extends JpaRepository<Courier, Integer> {
    @Query(value = "SELECT * FROM couriers_abr ORDER BY id OFFSET ?1 LIMIT ?2", nativeQuery = true)
    public List<Courier> findIdOrdered(int offset, int limit);

    @Query(value = "SELECT sum(o.cost) from couriers_abr as c\n" +
            "JOIN complete_order_abr as co on c.id = co.courier_id\n" +
            "JOIN orders_abr as o on o.id = co.order_id\n" +
            "WHERE co.complete_time > ?2 and\n" +
            "co.complete_time < ?3 and\n" +
            "c.id = ?1", nativeQuery = true)
    public Long getSumCostById(int id, Date startDate, Date endDate);

    @Query(value = "SELECT count(*) from couriers_abr as c\n" +
            "JOIN complete_order_abr as co on c.id = co.courier_id\n" +
            "JOIN orders_abr as o on o.id = co.order_id\n" +
            "WHERE co.complete_time > ?2 and\n" +
            "co.complete_time < ?3 and\n" +
            "c.id = ?1", nativeQuery = true)
    public Integer getCountOrderById(int id, Date startDate, Date endDate);
}
