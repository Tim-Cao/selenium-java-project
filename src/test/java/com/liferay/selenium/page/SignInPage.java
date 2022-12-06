package com.liferay.selenium.page;

import com.liferay.selenium.path.Button;
import com.liferay.selenium.path.Input;
import com.liferay.selenium.path.Link;
import static driver.BrowserDriver.*;
import org.openqa.selenium.WebElement;

public class SignInPage {

    public static void clickSignInLink() {
        WebElement signInLink = getElement(Link.SIGN_IN);
        signInLink.click();
    }

    public static void clickSignInButton() {
        WebElement signInLink = getElement(Button.SIGN_IN);
        signInLink.click();
    }
    public static void setEmailAddress(String emailAddress) {
        WebElement emailAddressInput = getElement(Input.EMAIL_ADDRESS);
        emailAddressInput.clear();
        emailAddressInput.sendKeys(emailAddress);
    }

    public static void setPassword(String password) {
        WebElement passwordInput = getElement(Input.PASSWORD);
        passwordInput.sendKeys(password);
    }

}