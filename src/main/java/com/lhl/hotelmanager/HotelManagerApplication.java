package com.lhl.hotelmanager;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lhl.hotelmanager.dao")
public class HotelManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagerApplication.class, args);
    }
}
