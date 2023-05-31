package com.abrashkovvadim.springboot.yand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FlywayConfig.class)
@EnableAspectJAutoProxy
public class YandApplication {

    public static void main(String[] args) {
        SpringApplication.run(YandApplication.class, args);
    }

}
