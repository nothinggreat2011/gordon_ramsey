package com.yadu.restaurant.driver;

import com.yadu.restaurant.Restaurant;
import com.yadu.restaurant.calculator.MaximumSatisfactionCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by ybhushan on 18/11/16.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.yadu.restaurant")
public class Application implements CommandLineRunner{

    @Autowired
    Restaurant restaurant;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    public void run(String... strings) throws Exception {
        restaurant.serveFood();
    }
}
