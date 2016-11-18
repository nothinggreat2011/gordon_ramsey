package com.yadu.restaurant;

/**
 * Created by ybhushan on 18/11/16.
 */
public class TestUtil {
    public static String getTestResource(String name) {
        return TestUtil.class.getClassLoader().getResource(name).getFile();
    }
}
