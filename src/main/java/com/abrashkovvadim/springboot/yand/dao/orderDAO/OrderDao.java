package com.abrashkovvadim.springboot.yand.dao.orderDAO;

import com.abrashkovvadim.springboot.yand.entity.courier.Courier;
import com.abrashkovvadim.springboot.yand.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT * FROM orders_abr ORDER BY id OFFSET ?1 LIMIT ?2", nativeQuery = true)
    public List<Order> findIdOrdered(int offset, int limit);
}
