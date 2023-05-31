package com.abrashkovvadim.springboot.yand.service.courierService;

import com.abrashkovvadim.springboot.yand.entity.courier.Courier;
import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourierService {
    public void persistCourier(List<Courier> courier) throws BadDataGivenException;
    public List<Courier> getCouriers(int limit, int offset);
    public Courier getCourier(int id) throws NoSuchEntityException;
    public long getCourierIncome(int id, String startDate, String endDate);
    public double getCourierRating(int id, String startDate, String endDate);
}
