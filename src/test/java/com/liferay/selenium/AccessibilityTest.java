package com.liferay.selenium;

import com.liferay.selenium.path.Link;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static driver.BrowserDriver.*;

public class AccessibilityTest {

    @BeforeEach
    public void setUp() {
        start();
        open("https://www.liferay.com/");
    }

    @AfterEach
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