package com.liferay.selenium.interactions;

import org.openqa.selenium.WindowType;

import static driver.BrowserDriver.*;

public class SelectWindow {
    public static void selectWindow(String windowID) {
        getDriver().switchTo().window(windowID);
    }

    public static void selectNewWindow() {
        getDriver().switchTo().newWindow(WindowType.TAB);
    }

}