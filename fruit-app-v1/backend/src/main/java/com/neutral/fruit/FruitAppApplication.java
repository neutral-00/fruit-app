package com.neutral.fruit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FruitAppApplication {

	public static void main(String[] args) {

        SpringApplication.run(FruitAppApplication.class, args);
        System.out.println("Fruit Application is running...");
	}

}
