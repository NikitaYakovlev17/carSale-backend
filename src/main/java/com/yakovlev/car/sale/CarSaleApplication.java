package com.yakovlev.car.sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSaleApplication.class, args);
	}

}

//drop table body, car_ad, color, drive, engine, generation, kitting, model, producer, transmission, "user";