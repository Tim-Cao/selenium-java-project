package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserDriver {

    private static WebDriver _webDriver;
    private static WebDriverWait _webDriverWait;

    public static void assertElementVisible(String locator) {
        WebElement element = getElement(locator);
        element.isDisplayed();
    }

    public static By getBy(String locator) {
        return By.xpath(locator);
    }

    public static WebElement getElement(String locator) {
        waitForElementPresent(locator);

        return _webDriver.findElement(getBy(locator));
    }

    public static WebDriver start() {
        System.setProperty("webdriver.chrome.driver","/home/liferay/Github/chromedriver");

        _webDriver = new ChromeDriver();

        WebDriver.Options options = _webDriver.manage();
        options.deleteAllCookies();
        options.window().maximize();

        return _webDriver;
    }
    public static void waitForElementPresent(String locator) {
        _webDriverWait = new WebDriverWait(_webDriver, Duration.ofSeconds(5));
        _webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getBy(locator)));

    }

}