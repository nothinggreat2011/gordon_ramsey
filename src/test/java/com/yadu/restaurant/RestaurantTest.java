package com.yadu.restaurant;

import com.yadu.restaurant.calculator.MaximumSatisfactionCalculator;
import com.yadu.restaurant.menu.Menu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ybhushan on 18/11/16.
 */
public class RestaurantTest {

    @Mock
    MaximumSatisfactionCalculator maximumSatisfactionCalculator;

    @InjectMocks
    Restaurant restaurant = new Restaurant();

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void shouldBeAbleToRunRestaurantInProperManner() {
        File source = new File(TestUtil.getTestResource("running_with_smaller_set.txt"));
        restaurant.serveFood(source);
        Mockito.verify(maximumSatisfactionCalculator,Mockito.times(1)).calculate(Mockito.any(Menu.class));

    }



}