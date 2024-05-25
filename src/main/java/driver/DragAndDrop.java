package driver;

import static driver.BrowserDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void dragAndDropOnElement(String source, String target) {
        WebElement sourceElement = getElement(source);
        WebElement targetElement = getElement(target);

        new Actions(getDriver())
                .dragAndDrop(sourceElement, targetElement)
                .perform();
    }

}