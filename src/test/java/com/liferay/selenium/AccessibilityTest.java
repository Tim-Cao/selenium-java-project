package com.liferay.selenium;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.liferay.selenium.path.Link;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

import static driver.BrowserDriver.*;

public class AccessibilityTest {
    WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        webDriver = start();
        webDriver.get("https://www.liferay.com/");
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }

    @Test
    public void scanHomePage() throws Exception {
        waitForElementPresent(Link.LEARN_MORE);

        AxeBuilder axeBuilder = new AxeBuilder();

        axeBuilder.withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"));

        Results results = axeBuilder.analyze(webDriver);

        List<Rule> rules = results.getViolations();

        if (!rules.isEmpty()) {
            AxeReporter.getReadableAxeResults("violations", webDriver, rules);

            throw new Exception(AxeReporter.getAxeResultString());
        }
    }

}