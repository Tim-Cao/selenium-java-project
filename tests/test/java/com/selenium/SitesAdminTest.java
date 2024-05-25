package com.selenium;

import com.selenium.page.SignInPage;
import com.selenium.path.Icon;
import com.selenium.path.Message;
import com.selenium.site.Site;
import com.selenium.util.Constants;
import driver.SelectFrame;

import static driver.BrowserDriver.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class SitesAdminTest {

    @BeforeMethod
    public void setUp() {
        start();
        open(Constants.portalURL);

        SignInPage.signIn("test@liferay.com", "test");

        assertElementVisible(Icon.USER_AVATAR);
    }

    @AfterMethod
    public void tearDown() {
        close();
    }

    @Test
    public void addBlankSite() {
        open(Constants.portalURL + "/group/control_panel/manage/-/sites");

        Site.addSite(RandomStringUtils.randomAlphanumeric(8), "Blank Site");

        SelectFrame.selectFrameTop();

        assertElementVisible(Message.SUCCESS_MESSAGE);
    }

    @Test
    public void addWelcomeSite() {
        open(Constants.portalURL + "/group/control_panel/manage/-/sites");

        Site.addSite(RandomStringUtils.randomAlphanumeric(8), "Welcome");

        SelectFrame.selectFrameTop();

        assertElementVisible(Message.SUCCESS_MESSAGE);
    }

}