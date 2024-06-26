package driver;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserDriver {

    public static void assertElementPresent(String locator) {
        List<WebElement> elements = getDriver().findElements(By.xpath(locator));
        Assert.assertFalse(elements.isEmpty());
    }

    public static void assertElementVisible(String locator) {
        WebElement element = getElement(locator);
        Assert.assertTrue(element.isDisplayed());
    }

    public static void close() {
        getDriver().quit();
    }

    public static By getBy(String locator) {
        return By.xpath(locator);
    }

    public static WebDriver getDriver() {
        return _threadLocalWebDriver.get();
    }

    public static WebElement getElement(String locator) {
        waitForElementPresent(locator);

        return getDriver().findElement(getBy(locator));
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void pause(long duration) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public static void scanPage(String filterByImpacts) throws Exception {
        AxeBuilder axeBuilder = new AxeBuilder();

        axeBuilder.withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"));

        Results results = axeBuilder.analyze(getDriver());

        List<Rule> rules = results.getViolations();

        if (!rules.isEmpty()) {
            List<Rule> violations = new ArrayList<Rule>();

            if (filterByImpacts.isEmpty()) {
                violations.addAll(rules);
            }
            else {
                List<String> filterByImpactsList = new ArrayList<String>(
                        Arrays.asList(filterByImpacts.split(",")));

                filterByImpactsList.stream()
                    .forEach(
                        filterByImpact -> violations.addAll(
                                rules.stream()
                                    .filter(
                                        rule -> rule.getImpact().equals(filterByImpact)
                                    ).collect(Collectors.toList())
                        )
                    );
            }

            AxeReporter.getReadableAxeResults("violations", getDriver(), violations);

            throw new Exception(AxeReporter.getAxeResultString());
        }
    }

    public static void scanColorContrast() throws Exception {
        AxeBuilder axeBuilder = new AxeBuilder();

        axeBuilder.withOnlyRules(Arrays.asList("color-contrast"));

        Results results = axeBuilder.analyze(getDriver());

        List<Rule> rules = results.getViolations();

        if (!rules.isEmpty()) {
            AxeReporter.getReadableAxeResults("violations", getDriver(), rules);

            throw new Exception(AxeReporter.getAxeResultString());
        }
    }

    public static void start() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        _threadLocalWebDriver.set(webDriver);
    }

    public static WebDriver.TargetLocator switchTo() {
        WebDriver.TargetLocator targetLocator = getDriver().switchTo();

        return targetLocator;
    }

    public static void waitForElementPresent(String locator) {
        _webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        _webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getBy(locator)));

    }

    private static ThreadLocal<WebDriver> _threadLocalWebDriver = new ThreadLocal<>();

    private static WebDriverWait _webDriverWait;

}