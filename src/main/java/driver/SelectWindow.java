package driver;

import org.openqa.selenium.WindowType;

import static driver.BrowserDriver.*;

public class SelectWindow {
    public static void selectWindow(String windowID) {
        switchTo().window(windowID);
    }

    public static void selectNewWindow() {
        switchTo().newWindow(WindowType.TAB);
    }

}