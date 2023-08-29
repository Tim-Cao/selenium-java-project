package driver;

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
import java.util.Arrays;
import java.util.List;

public class BrowserDriver {

    public static void assertElementVisible(String locator) {
        WebElement element = getElement(locator);
        element.isDisplayed();
    }

    public static void close() {
        getDriver().quit();
    }

    public static By getBy(String locator) {
        return By.xpath(locator);
    }

    public static WebElement getElement(String locator) {
        waitForElementPresent(locator);

        return getDriver().findElement(getBy(locator));
    }

    public static void open(String url) {
        getDriver().get(url);
    }

    public static void pause(long duration) {
        _webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(duration));
    }

    public static void scanPage() throws Exception {
        AxeBuilder axeBuilder = new AxeBuilder();

        axeBuilder.withTags(Arrays.asList("wcag2a", "wcag2aa", "wcag21a", "wcag21aa"));

        Results results = axeBuilder.analyze(getDriver());

        List<Rule> rules = results.getViolations();

        if (!rules.isEmpty()) {
            AxeReporter.getReadableAxeResults("violations", getDriver(), rules);

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

    private static WebDriver getDriver() {
        return _threadLocalWebDriver.get();
    }
    private static WebDriverWait _webDriverWait;

}