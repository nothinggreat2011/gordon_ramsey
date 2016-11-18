package com.yadu.restaurant.menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ybhushan on 18/11/16.
 */
public class Menu {

    public static final String INVALID_FILE_FORMAT = "Invalid file format";
    public static final String NEGATIVE_VALUES_ARE_NOT_ALLOWED_IN_THIS_RESTAURANT = "Negative values are not allowed in this restaurant...!";
    private int maxTime = 0;
    private List<MenuItem> menuItemList;

    public Menu(File source) {

        if(source == null) {
            throw new RuntimeException(INVALID_FILE_PROVIDED);
        }

        parseTheSourceAndFillTheMenu(source);
    }

    private void parseTheSourceAndFillTheMenu(File source) {
        try {
            Scanner scanner  = new Scanner(new FileInputStream(source));
            validateIfThereIsAnNextElement(scanner);
            maxTime = getNextValue(scanner);
            parseAndFillTheMenuItem(scanner);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private void parseAndFillTheMenuItem(Scanner scanner) {
        validateIfThereIsAnNextElement(scanner);
        int numberOfItems = getNextValue(scanner);
        menuItemList = new ArrayList<MenuItem>(numberOfItems);
        for(int i = 1; i<=numberOfItems; i++) {
            menuItemList.add(parseLineAndCreateMenuItem(scanner, i));
        }

    }

    private int getNextValue(Scanner scanner) {
        int anInt = scanner.nextInt();
        if(anInt < 0) {
            throw new RuntimeException(NEGATIVE_VALUES_ARE_NOT_ALLOWED_IN_THIS_RESTAURANT);
        }
        return anInt;
    }

    private void validateIfThereIsAnNextElement(Scanner scanner) {
        if(!scanner.hasNextInt()){
            throw new RuntimeException(INVALID_FILE_FORMAT);
        }
    }

    private MenuItem parseLineAndCreateMenuItem(Scanner scanner, int index) {
        validateIfThereIsAnNextElement(scanner);
        int satisFaction = getNextValue(scanner);
        validateIfThereIsAnNextElement(scanner);
        int timeTakenToEat = getNextValue(scanner);
        return new MenuItem("Item_"+index, satisFaction, timeTakenToEat);
    }

    public static final String INVALID_FILE_PROVIDED = "Invalid file provided";


    public int getMaxTime() {
        return maxTime;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

}
