package driver;

import static driver.BrowserDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {
    public static void doubleClick(String locator) {
        WebElement webElement = getElement(locator);

        new Actions(getDriver())
                .doubleClick(webElement)
                .perform();
    }

}