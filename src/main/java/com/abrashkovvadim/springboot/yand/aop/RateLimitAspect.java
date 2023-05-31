package com.abrashkovvadim.springboot.yand.aop;

import com.abrashkovvadim.springboot.yand.controller.AppControllerWithRateLimit;
import com.abrashkovvadim.springboot.yand.controller.courierController.CourierController;
import com.abrashkovvadim.springboot.yand.exception_handling.RateLimitException;
import io.github.bucket4j.Bucket;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class RateLimitAspect {

    @Around(value = "execution(public * com.abrashkovvadim.springboot.yand.controller.*.*.*(..))")
    public Object BeforeEndpointCheckLimitAdvice(ProceedingJoinPoint jp) throws NoSuchFieldException, RateLimitException, Throwable {
        System.out.println("Before_advice");
        Object target = jp.getTarget();

        if (target instanceof AppControllerWithRateLimit controller) {
            Bucket b  = controller.getBucket();
            if(!b.tryConsume(1)) throw new RateLimitException("Rate limit exceeded");
            System.out.println(b.getAvailableTokens());
        }
        return jp.proceed();
    }
}
