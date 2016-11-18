package com.yadu.restaurant.menu;

/**
 * Created by ybhushan on 18/11/16.
 */
public class MenuItem {

    private String name;
    private int satisfaction;
    private int timeTakenToEat;


    public MenuItem(String name, int satisfaction, int timeTakenToEat) {
        this.name = name;
        this.satisfaction = satisfaction;
        this.timeTakenToEat = timeTakenToEat;
    }

    public String getName() {
        return name;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public int getTimeTakenToEat() {
        return timeTakenToEat;
    }
}
