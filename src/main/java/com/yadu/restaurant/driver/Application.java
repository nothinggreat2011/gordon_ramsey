package com.yadu.restaurant.driver;

import com.yadu.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

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
        displaySomeLines();

        String path = strings[0];
        if(path == null || path.isEmpty()) {
            throw new RuntimeException("Cannot run application without file source. ");
        }
        restaurant.serveFood(new File(path));

        displaySomeLines();
    }

    private void displaySomeLines() {
        System.out.println("================================+++++++++++++++++++++++++++++++++===================================");
        System.out.println("================================+++++++++++++++++++++++++++++++++===================================");
    }
}
