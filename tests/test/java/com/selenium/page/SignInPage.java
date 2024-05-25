package com.selenium.page;

import com.selenium.path.Button;
import com.selenium.path.Input;
import com.selenium.path.Link;
import static driver.BrowserDriver.*;

import org.openqa.selenium.WebElement;

public class SignInPage {

    private static void clickSignInLink() {
        WebElement signInLink = getElement(Link.SIGN_IN);
        signInLink.click();
    }

    private static void clickSignInButton() {
        WebElement signInLink = getElement(Button.SIGN_IN);
        signInLink.click();
    }
    private static void setEmailAddress(String emailAddress) {
        WebElement emailAddressInput = getElement(Input.EMAIL_ADDRESS);
        emailAddressInput.clear();
        emailAddressInput.sendKeys(emailAddress);
    }

    private static void setPassword(String password) {
        WebElement passwordInput = getElement(Input.PASSWORD);
        passwordInput.sendKeys(password);
    }

    public static void signIn(String emailAddress, String password) {
        SignInPage.clickSignInLink();
        SignInPage.setEmailAddress(emailAddress);
        SignInPage.setPassword(password);
        SignInPage.clickSignInButton();
    }

}