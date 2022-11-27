package com.liferay.selenium;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import com.liferay.selenium.path.Link;
import com.liferay.selenium.webDriver.BrowserDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AccessibilityTesting {
    WebDriver browserDriver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        browserDriver = BrowserDriver.start();
        browserDriver.get("https://www.liferay.com/");
    }

    @AfterEach
    public void tearDown() {
        browserDriver.quit();
    }

    @Test
    public void scanHomePage() throws Exception {
        wait = new WebDriverWait(browserDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BrowserDriver.getBy(Link.LEARN_MORE)));

        AxeBuilder axeBuilder = new AxeBuilder();

        axeBuilder.withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"));

        Results results = axeBuilder.analyze(browserDriver);

        List<Rule> rules = results.getViolations();

        if (!rules.isEmpty()) {
            AxeReporter.getReadableAxeResults("violations", browserDriver, rules);

            throw new Exception(AxeReporter.getAxeResultString());
        }
    }

}