package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

public class ScreenshotUtils {

    public static byte[] captureScreenshot(WebDriver driver) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            LoggerFactory.getLogger(ScreenshotUtils.class).error("Screenshot capture failed -> {}", e.getMessage());
            return new byte[0];
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public static byte[] attachScreenshot(WebDriver driver) {
        byte[] value = ScreenshotUtils.captureScreenshot(driver);
        return value;
    }
}
