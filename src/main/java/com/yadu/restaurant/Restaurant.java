package com.yadu.restaurant;

import com.yadu.restaurant.calculator.MaximumSatisfactionCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ybhushan on 18/11/16.
 */

@Component
public class Restaurant {

    @Autowired
    private MaximumSatisfactionCalculator maximumSatisfactionCalculator;

    public void serveFood() {
        System.out.println("Serving.....");
        maximumSatisfactionCalculator.calculate();
    }
}
