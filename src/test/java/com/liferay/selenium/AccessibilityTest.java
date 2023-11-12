package com.liferay.selenium;

import com.liferay.selenium.path.Link;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static driver.BrowserDriver.*;

public class AccessibilityTest {

    @Before
    public void setUp() {
        start();
        open("https://www.liferay.com/");
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void scanHomePage() throws Exception {
        waitForElementPresent(Link.LEARN_MORE);

        scanPage("");
    }

    @Test
    public void scanHomePageBySpecificImpacts() throws Exception {
        waitForElementPresent(Link.LEARN_MORE);

        scanPage("critical,serious");
    }

    @Test
    public void scanHomePageColorContrast() throws Exception {
        waitForElementPresent(Link.LEARN_MORE);

        scanColorContrast();
    }

}