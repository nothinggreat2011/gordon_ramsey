package com.yadu.restaurant.menu;

import com.yadu.restaurant.TestUtil;
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

        File file = new File(TestUtil.getTestResource("TestThatWeAreAbleToParseTheFile.txt"));
        Menu menu = new Menu(file);
        Assert.assertNotNull(menu);
        Assert.assertNotNull(menu.getMenuItemList());
        Assert.assertEquals(100, menu.getMaxTime());
    }

    @Test
    public void shouldNotBeAbleToParseTheFileWhenTheFileIsEmpty() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.INVALID_FILE_FORMAT);
        File file = new File(TestUtil.getTestResource("Empty.txt"));
        new Menu(file);
    }

    @Test
    public void shouldNotBeAbleToParseTheFileWhenTheFileContainsNegativeElements() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.NEGATIVE_VALUES_ARE_NOT_ALLOWED_IN_THIS_RESTAURANT);
        File file = new File(TestUtil.getTestResource("NegativeData.txt"));
        new Menu(file);
    }


    @Test
    public void shouldNotBeAbleToParseTheFileWhenTheFileIsHavingLessData() {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(Menu.INVALID_FILE_FORMAT);
        File file = new File(TestUtil.getTestResource("LessData.txt"));
        new Menu(file);
    }


  

}