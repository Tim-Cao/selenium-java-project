package com.liferay.selenium.interactions;

import static driver.BrowserDriver.*;

public class SelectWindow {
    public static void selectWindow(String windowID) {
        getDriver().switchTo().window(windowID);
    }

}