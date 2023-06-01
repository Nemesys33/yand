package com.abrashkovvadim.springboot.yand.controller.courierController;

import com.abrashkovvadim.springboot.yand.controller.AppControllerWithRateLimit;
import com.abrashkovvadim.springboot.yand.entity.courier.Courier;
import com.abrashkovvadim.springboot.yand.entity.courier.CourierList;
import com.abrashkovvadim.springboot.yand.entity.courier.CourierMetaInfo;
import com.abrashkovvadim.springboot.yand.exception_handling.BadDataGivenException;
import com.abrashkovvadim.springboot.yand.exception_handling.NoSuchEntityException;
import com.abrashkovvadim.springboot.yand.service.courierService.CourierService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/couriers")
public class CourierController implements AppControllerWithRateLimit {

    @Resource
    private CourierService courierService;

    private final Map<String, Bucket> bucketsForEndpoints = new HashMap<>();

    public Bucket getBucket(String method) {
        return bucketsForEndpoints.get(method);
    }

    public CourierController() {
        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofSeconds(1)));
        for(Method method: CourierController.class.getMethods()){
            String name = method.getName();
            if(!Arrays.stream(Object.class.getMethods()).toList().contains(method) && !name.equals("getBucket"))
                bucketsForEndpoints.put(name, Bucket.builder().addLimit(limit).build());
        }
    }

    @PostMapping("")
    public void persistCourier(@RequestBody CourierList cl) throws BadDataGivenException {
        System.out.println(cl.getCouriers());
        courierService.persistCourier(cl.getCouriers());
    }

    @GetMapping("")
    public List<Courier> getCouriers(@RequestParam(value = "limit",
            required = false, defaultValue = "1") int limit,
                                     @RequestParam(value = "offset",
            required = false, defaultValue = "0") int offset) {

        return courierService.getCouriers(limit, offset);
    }

    @GetMapping("/{id}")
    public Courier getCourier(@PathVariable int id) throws NoSuchEntityException {
        return courierService.getCourier(id);
    }

    @GetMapping("/meta-info/{id}")
    public CourierMetaInfo getCourierMetaInfo(@PathVariable int id,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate){
        var income = courierService.getCourierIncome(id, startDate, endDate);
        if(income == -1) return null;
        var rating = courierService.getCourierRating(id, startDate, endDate);
        if(rating == -1) return null;
        return new CourierMetaInfo(income, rating);
    }
}
