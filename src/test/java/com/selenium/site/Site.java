package com.selenium.site;

import com.selenium.path.Button;
import com.selenium.path.Card;
import com.selenium.path.Icon;
import com.selenium.path.Input;
import driver.SelectFrame;

import static driver.BrowserDriver.*;

import org.openqa.selenium.WebElement;

public class Site {

    public static void addSite(String siteName, String siteInitializer) {
        pause(5);

        WebElement plusIcon = getElement(Icon.ADD_SITE);
        plusIcon.click();

        if (siteInitializer.equals("Blank Site")) {
            WebElement siteTemplate = getElement(Card.BLANK_SITE);
            siteTemplate.click();
        }
        else if (siteInitializer.equals("Welcome")) {
            WebElement siteTemplate = getElement(Card.WELCOME);
            siteTemplate.click();
        }

        SelectFrame.selectFrame("//div[contains(@class,'modal-body')]//iframe");

        WebElement nameInput = getElement(Input.NAME);
        nameInput.sendKeys(siteName);

        WebElement saveButton = getElement(Button.ADD);
        saveButton.click();
    }

}
