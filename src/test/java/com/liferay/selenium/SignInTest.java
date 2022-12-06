package com.liferay.selenium;

import com.liferay.selenium.page.SignInPage;
import com.liferay.selenium.path.Icon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static driver.BrowserDriver.*;

public class SignInTest {

    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        webDriver = start();
        webDriver.get("http://localhost:8080");
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void login() {
        SignInPage.clickSignInLink();
        SignInPage.setEmailAddress("test@liferay.com");
        SignInPage.setPassword("test");
        SignInPage.clickSignInButton();

        assertElementVisible(Icon.USER_AVATAR);
    }

}