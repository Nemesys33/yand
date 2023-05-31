package com.abrashkovvadim.springboot.yand.service.orderService;

import com.abrashkovvadim.springboot.yand.entity.order.CompleteOrder;
import com.abrashkovvadim.springboot.yand.entity.order.Order;
import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    public void persistOrders(List<Order> orderList) throws BadDataGivenException;
    public void CompleteOrder(List<CompleteOrder> completeOrders) throws BadDataGivenException;
    public List<Order> getOrders(int limit, int offset);
    public Order getOrder(int id) throws NoSuchEntityException;
}
