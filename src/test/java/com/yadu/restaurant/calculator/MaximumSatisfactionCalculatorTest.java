package com.yadu.restaurant.calculator;

import com.yadu.restaurant.TestUtil;
import com.yadu.restaurant.menu.Menu;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ybhushan on 18/11/16.
 */
public class MaximumSatisfactionCalculatorTest {
    MaximumSatisfactionCalculator maximumSatisfactionCalculator = new MaximumSatisfactionCalculator();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenTheMenuIsNull() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(MaximumSatisfactionCalculator.INVALID_MENU_PROVIDED);
        maximumSatisfactionCalculator.calculate(null);
    }

    @Test
    public void shouldBeAbleToCalculateTheMaximumSatisfaction() {
        File source = new File(TestUtil.getTestResource("running_with_smaller_set.txt"));
        Menu menu = new Menu(source);
        int maximumSatisfaction = maximumSatisfactionCalculator.calculate(menu);
        Assert.assertEquals(182, maximumSatisfaction);
    }






}