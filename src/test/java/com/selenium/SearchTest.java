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
    public void searchByKeywords() {
        open("https://www.baidu.com");

        SearchPage.type("//input[contains(@class,'s_ipt')]", "今日热点");
        SearchPage.clickSearchButton("//input[@type='submit']");

        assertElementVisible("//a[normalize-space()='今日热点的最新相关信息']");
    }

}