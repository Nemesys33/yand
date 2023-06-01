package com.abrashkovvadim.springboot.yand.controller.orderController;

import com.abrashkovvadim.springboot.yand.controller.AppControllerWithRateLimit;
import com.abrashkovvadim.springboot.yand.entity.order.CompleteOrderList;
import com.abrashkovvadim.springboot.yand.entity.order.CompleteOrdersId;
import com.abrashkovvadim.springboot.yand.entity.order.Order;
import com.abrashkovvadim.springboot.yand.entity.order.OrderList;
import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import com.abrashkovvadim.springboot.yand.service.orderService.OrderService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/orders")
public class OrderController implements AppControllerWithRateLimit {

    @Resource
    private OrderService orderService;

    private final Map<String, Bucket> bucketsForEndpoints = new HashMap<>();


    public Bucket getBucket(String method) {
        return bucketsForEndpoints.get(method);
    }

    public OrderController() {
        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofSeconds(1)));
        for(Method method: OrderController.class.getMethods()) {
            bucketsForEndpoints.put(method.getName(), Bucket.builder().addLimit(limit).build());
        }
    }

    @PostMapping("")
    public void persistOrders(@RequestBody OrderList orderList) throws BadDataGivenException{
        System.out.println(orderList.getOrders());

        orderService.persistOrders(orderList.getOrders());
    }

    @PostMapping("/complete")
    public CompleteOrdersId CompleteOrder(@RequestBody CompleteOrderList col) throws BadDataGivenException {
        System.out.println(col.getComplete_info());

        orderService.CompleteOrder(col.getComplete_info());

        List<Integer> ids = new ArrayList<>();
        for(var co: col.getComplete_info()){
            ids.add(co.getOrder_id());
        }
        return new CompleteOrdersId(ids);
    }

    @GetMapping("")
    public List<Order> getOrders(
            @RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "0") int offset) {

        return orderService.getOrders(limit, offset);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) throws NoSuchEntityException {
        return orderService.getOrder(id);
    }
}
