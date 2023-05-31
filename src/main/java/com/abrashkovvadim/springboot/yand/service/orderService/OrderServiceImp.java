package com.abrashkovvadim.springboot.yand.service.orderService;

import com.abrashkovvadim.springboot.yand.dao.orderDAO.CompleteOrderDao;
import com.abrashkovvadim.springboot.yand.dao.orderDAO.OrderDao;
import com.abrashkovvadim.springboot.yand.entity.order.CompleteOrder;
import com.abrashkovvadim.springboot.yand.entity.order.Order;
import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService{

    @Resource
    private OrderDao orderDao;
    @Resource
    private CompleteOrderDao completeOrderDao;

    @Override
    public void persistOrders(List<Order> orderList) throws BadDataGivenException {
        try {
            orderDao.saveAll(orderList);
        } catch(Exception e) {
            throw new BadDataGivenException("Bad data given");
        }
    }

    @Override
    public void CompleteOrder(List<CompleteOrder> completeOrders) throws BadDataGivenException {
        try {
            completeOrderDao.saveAll(completeOrders);
        } catch(Exception e) {
            throw new BadDataGivenException("Bad data given");
        }
        for(var compOr: completeOrders){
            Order order = orderDao.findById(compOr.getOrder_id()).get();
            order.setCompleted(true);
            orderDao.flush();
        }
    }

    @Override
    public List<Order> getOrders(int limit, int offset) {
        return orderDao.findIdOrdered(offset, limit);
    }

    @Override
    public Order getOrder(int id) throws NoSuchEntityException {
        return orderDao.findById(id).orElseThrow(()
                -> new NoSuchEntityException("There are no order with id = " + id));
    }
}
