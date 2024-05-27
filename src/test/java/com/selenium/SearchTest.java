package com.selenium;

import com.selenium.page.SearchPage;
import org.junit.*;

import static driver.BrowserDriver.*;

public class SearchTest {

    @Before
    public void setUp() {
        start();
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void testSearchByKeywords() {
        open("https://www.baidu.com");

        SearchPage.type("//input[contains(@class,'s_ipt')]", "今日热点");
        SearchPage.clickSearchButton("//input[@type='submit']");

        assertElementVisible("//span[normalize-space()='百度为您找到以下结果']");
    }

}