package com.yadu.restaurant;

import com.yadu.restaurant.calculator.MaximumSatisfactionCalculator;
import com.yadu.restaurant.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Created by ybhushan on 18/11/16.
 */

@Component
public class Restaurant {

    @Autowired
    private MaximumSatisfactionCalculator maximumSatisfactionCalculator;

    public void serveFood(File file) {

        System.out.println("Calculating the maximum satisfaction.....");
        Menu menu = new Menu(file);
        int calculate = maximumSatisfactionCalculator.calculate(menu);
        System.out.println("Maximum satisfaction is " + calculate);
    }
}
