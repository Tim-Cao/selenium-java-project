package driver;

import static driver.BrowserDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectField {
    public static void selectOption(String locator, String optionValue) {
        WebElement webElement = getElement(locator);

        Select select = new Select(webElement);
        select.selectByValue(optionValue);
    }

}