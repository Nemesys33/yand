package com.abrashkovvadim.springboot.yand.dao.orderDAO;

import com.abrashkovvadim.springboot.yand.entity.order.CompleteOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompleteOrderDao extends JpaRepository<CompleteOrder, Integer> {
}
