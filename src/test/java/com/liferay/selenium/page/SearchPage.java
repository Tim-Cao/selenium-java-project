package com.liferay.selenium.page;

import static driver.BrowserDriver.*;
import org.openqa.selenium.WebElement;

public class SearchPage {

    public static void clickSearchButton(String locator) {
        WebElement searchButton = getElement(locator);
        searchButton.click();
    }

    public static void type(String locator, String text) {
        WebElement searchField = getElement(locator);
        searchField.sendKeys(text);
    }

}