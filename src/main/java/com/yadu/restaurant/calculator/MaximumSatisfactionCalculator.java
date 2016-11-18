package com.yadu.restaurant.calculator;

import com.yadu.restaurant.menu.Menu;
import com.yadu.restaurant.menu.MenuItem;
import org.springframework.stereotype.Component;

/**
 * Created by ybhushan on 18/11/16.
 */
@Component
public class MaximumSatisfactionCalculator {

    public static final String INVALID_MENU_PROVIDED = "Invalid menu provided!!!";

    public int  calculate(Menu menu){

        if(menu == null) {
            throw new RuntimeException(INVALID_MENU_PROVIDED);
        }

        int maxTime = menu.getMaxTime();
        int numberOfDishes = menu.getMenuItemList().size();
        int array[][] = new int[numberOfDishes +1][maxTime+1];
        for(int i = 0; i <= numberOfDishes; i++){
            for(int j=0; j <= maxTime; j++){
                if(i == 0 || j == 0){
                    array[i][j] = 0;
                    continue;
                }
                MenuItem menuItem = menu.getMenuItemList().get(i - 1);
                int timeTakeToEat = menuItem.getTimeTakenToEat();
                int satisfaction  = menuItem.getSatisfaction();
                if(j - timeTakeToEat >= 0){
                    array[i][j] = Math.max(array[i-1][j], array[i-1][j-timeTakeToEat] + satisfaction);
                }else{
                    array[i][j] = array[i-1][j];
                }
            }
        }
        return array[numberOfDishes][maxTime];

    }

}
