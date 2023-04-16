package com.liferay.selenium;

import com.liferay.selenium.frame.SelectFrame;
import com.liferay.selenium.page.SignInPage;
import com.liferay.selenium.path.Icon;
import com.liferay.selenium.path.Message;
import com.liferay.selenium.site.Site;
import com.liferay.selenium.util.*;

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