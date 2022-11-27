package com.liferay.selenium;

import com.liferay.selenium.page.SignInPage;
import com.liferay.selenium.path.Icon;
import com.liferay.selenium.webDriver.BrowserDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInTest {

    WebDriver browserDriver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        browserDriver = BrowserDriver.start();
        browserDriver.get("http://localhost:8080");
    }

    @AfterEach
    public void tearDown() {
        browserDriver.quit();
    }

    @Test
    public void login() {
        SignInPage signInPage = new SignInPage(browserDriver);
        signInPage.clickSignInLink();
        signInPage.setEmailAddress("test@liferay.com");
        signInPage.setPassword("test");
        signInPage.clickSignInButton();

        wait = new WebDriverWait(browserDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrowserDriver.getBy(Icon.USER_AVATAR)));
        browserDriver.findElement(BrowserDriver.getBy(Icon.USER_AVATAR)).isDisplayed();
    }

}