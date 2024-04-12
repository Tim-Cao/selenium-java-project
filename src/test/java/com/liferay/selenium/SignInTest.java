package com.liferay.selenium;

import com.liferay.selenium.page.SignInPage;
import com.liferay.selenium.path.Icon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static driver.BrowserDriver.*;

public class SignInTest {

    @Before
    public void setUp() {
        start();
        open("http://localhost:8080");
    }

    @After
    public void tearDown() {
        close();
    }

    @Test
    public void testLogin() {
        SignInPage.signIn("test@liferay.com", "test");

        assertElementVisible(Icon.USER_AVATAR);
    }

}