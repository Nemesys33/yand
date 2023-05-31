package com.abrashkovvadim.springboot.yand.service.courierService;

import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import com.abrashkovvadim.springboot.yand.dao.courierDAO.CourierDao;
import com.abrashkovvadim.springboot.yand.entity.courier.Courier;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImp implements CourierService{

    @Resource
    private CourierDao courierDao;

    @Override
    public void persistCourier(List<Courier> courier) throws BadDataGivenException {
        try {
            courierDao.saveAll(courier);
        } catch(Exception e) {
            throw new BadDataGivenException("Bad data given");
        }
    }

    @Override
    public List<Courier> getCouriers(int limit, int offset) {
        return courierDao.findIdOrdered(offset, limit);
    }

    @Override
    public Courier getCourier(int id) throws NoSuchEntityException{
        return courierDao.findById(id).orElseThrow(()
                -> new NoSuchEntityException("There are no courier with id =" + id));
    }

    public long getCourierIncome(int id, String startDate, String endDate){
        Optional<Courier> courier = courierDao.findById(id);
        Courier c;
        if(courier.isPresent())
            c = courier.get();
        else return -1;

        Date end = stringToDate(endDate);
        Date start = stringToDate(startDate);
        if(end.getTime() <= start.getTime()) return -1;

        Long sumcost = courierDao.getSumCostById(id, start, end);
        if(sumcost == null) return -1;

        int coef = c.getCourier_type().ordinal() + 2;

        return sumcost*coef;
    }

    public double getCourierRating(int id, String startDate, String endDate){
        Optional<Courier> courier = courierDao.findById(id);
        Courier c;
        if(courier.isPresent())
            c = courier.get();
        else return -1;

        int coef = 3 - c.getCourier_type().ordinal();

        Date end = stringToDate(endDate);
        Date start = stringToDate(startDate);
        if(end.getTime() <= start.getTime()) return -1;

        Integer orderCount = courierDao.getCountOrderById(id, start, end);
        if(orderCount == null) return -1;

        long countHours = (end.getTime() - start.getTime())/(60*60*1000);

        return Math.round((orderCount/(double)countHours)*coef*100)/100.0;
    }

    private Date stringToDate(String strDate){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
