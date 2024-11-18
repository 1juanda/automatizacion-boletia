package utilidades;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException, InterruptedException {
        Thread.sleep(3000);
        fileName = fileName + ".png";
        String directory = "./Screen/";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        return directory + fileName;
    }
}