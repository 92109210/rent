package com.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.house.dao")
public class HouseRentApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseRentApplication.class, args);
    }

}
