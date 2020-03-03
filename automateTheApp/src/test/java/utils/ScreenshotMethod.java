package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotMethod {
    public static void takeScreenShot() throws IOException {
        File src=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File desFile=new File("ScreenShots/"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(src, desFile);
    }
    }

