package driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import static driver.BrowserDriver.*;


public class TakesScreenShot {
    public static void takesScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshot, new File(fileName));
    }

}
