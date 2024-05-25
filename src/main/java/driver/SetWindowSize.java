package driver;

import org.openqa.selenium.Dimension;

import static driver.BrowserDriver.*;


public class SetWindowSize {
    public static void setWindowSize(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

}