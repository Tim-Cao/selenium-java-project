package driver;

import org.openqa.selenium.JavascriptExecutor;

import static driver.BrowserDriver.*;

public class Scroll {
    public static void scrollBy(String offset) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();

        js.executeScript("window.scrollBy("+ offset+ ");");
    }

    public static void scrollIntoElement(String locator) {
        JavascriptExecutor js = (JavascriptExecutor)getDriver();

        js.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
    }

}
