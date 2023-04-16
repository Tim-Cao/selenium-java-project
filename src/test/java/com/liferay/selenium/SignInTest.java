package com.liferay.selenium;

import com.liferay.selenium.page.SignInPage;
import com.liferay.selenium.path.Icon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static driver.BrowserDriver.*;

public class SignInTest {

    @BeforeEach
    public void setUp() {
        start();
        open("http://localhost:8080");
    }

    @AfterEach
    public void tearDown() {
        close();
    }

    @Test
    public void login() {
        SignInPage.signIn("test@liferay.com", "test");

        assertElementVisible(Icon.USER_AVATAR);
    }

}