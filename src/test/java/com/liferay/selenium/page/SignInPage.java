package com.liferay.selenium.page;

import com.liferay.selenium.path.Button;
import com.liferay.selenium.path.Input;
import com.liferay.selenium.path.Link;
import com.liferay.selenium.webDriver.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    WebDriver browser;
    WebDriverWait wait;

    public SignInPage(WebDriver browserDriver) {
        browser = browserDriver;

        wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrowserDriver.getBy(Link.SIGN_IN)));
    }

    public void setEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrowserDriver.getBy(Input.EMAIL_ADDRESS)));
        WebElement emailAddressInput = browser.findElement(BrowserDriver.getBy(Input.EMAIL_ADDRESS));
        emailAddressInput.clear();
        emailAddressInput.sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrowserDriver.getBy(Input.PASSWORD)));
        WebElement passwordInput = browser.findElement(BrowserDriver.getBy(Input.PASSWORD));
        passwordInput.sendKeys(password);
    }

    public void clickSignInLink() {
        WebElement signInLink = browser.findElement(BrowserDriver.getBy(Link.SIGN_IN));
        signInLink.click();
    }

    public void clickSignInButton() {
        WebElement signInLink = browser.findElement(BrowserDriver.getBy(Button.SIGN_IN));
        signInLink.click();
    }

}