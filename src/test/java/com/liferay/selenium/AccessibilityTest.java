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
        open("https://www.github.com/");
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void scanHomePage() throws Exception {
        waitForElementPresent(Link.SIGN_IN);

        scanPage("");
    }

    @Test
    public void scanHomePageBySpecificImpacts() throws Exception {
        waitForElementPresent(Link.SIGN_IN);

        scanPage("critical,serious");
    }

    @Test
    public void scanHomePageColorContrast() throws Exception {
        waitForElementPresent(Link.SIGN_IN);

        scanColorContrast();
    }

}