package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static driver.BrowserDriver.*;

import java.util.Stack;

public class SelectFrame {
    public static void selectFrame(String locator) {
        WebDriver.TargetLocator targetLocator = switchTo();

        _frameWebElements.push(getElement(locator));

        targetLocator.frame(_frameWebElements.peek());
    }

    public static void selectParentFrame(String locator) {
        WebDriver.TargetLocator targetLocator = switchTo();

        targetLocator.parentFrame();
    }

    public static void selectFrameTop() {
        WebDriver.TargetLocator targetLocator = switchTo();

        _frameWebElements.clear();

        targetLocator.defaultContent();
    }

    private static final Stack<WebElement> _frameWebElements = new Stack<>();

}
