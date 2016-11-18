package com.yadu.restaurant.menu;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

/**
 * Created by ybhushan on 18/11/16.
 */
public class MenuTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();




    @Test()
    public void shouldThrowExceptionWhenFileIsNull() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.INVALID_FILE_PROVIDED);
        File file = null;
        new Menu(file);

    }

    @Test
    public void shouldThrowExceptionWhenFileNotFound() {

        expectedException.expect(RuntimeException.class);
        File file = new File("");
        new Menu(file);
    }

    @Test
    public void shouldBeAbleToParseTheFileAndBuildMenu() {

        File file = new File(getTestResource("TestThatWeAreAbleToParseTheFile.txt"));
        Menu menu = new Menu(file);
        Assert.assertNotNull(menu);
        Assert.assertNotNull(menu.getMenuItemList());
        Assert.assertEquals(100, menu.getMaxTime());
    }

    @Test
    public void shouldNotBeAbleToParseTheFileWhenTheFileIsEmpty() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.INVALID_FILE_FORMAT);
        File file = new File(getTestResource("Empty.txt"));
        new Menu(file);
    }

    @Test
    public void shouldNotBeAbleToParseTheFileWhenTheFileIsHavingLessData() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.INVALID_FILE_FORMAT);
        File file = new File(getTestResource("LessData.txt"));
        new Menu(file);
    }


    private String getTestResource(String name) {
        return this.getClass().getClassLoader().getResource(name).getFile();
    }

}