package com.liferay.selenium.webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriver {
    public static WebDriver start() {
        System.setProperty("webdriver.chrome.driver","/home/liferay/Github/chromedriver");
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static By getBy(String locator) {
        return By.xpath(locator);
    }
}
