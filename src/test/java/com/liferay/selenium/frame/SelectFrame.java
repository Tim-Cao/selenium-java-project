package com.liferay.selenium.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Stack;

import static driver.BrowserDriver.getElement;
import static driver.BrowserDriver.switchTo;

public class SelectFrame {
    public static void selectFrame(String locator) {
        WebDriver.TargetLocator targetLocator = switchTo();

        _frameWebElements.push(getElement(locator));

        targetLocator.frame(_frameWebElements.peek());
    }

    public static void selectFrameTop() {
        WebDriver.TargetLocator targetLocator = switchTo();

        _frameWebElements.clear();

        targetLocator.defaultContent();
    }

    private static final Stack<WebElement> _frameWebElements = new Stack<>();

}
