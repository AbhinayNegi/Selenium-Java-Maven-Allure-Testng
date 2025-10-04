package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureTestListener implements ITestListener {

    private static final Logger logger = LoggerFactory.getLogger(AllureTestListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTest) testInstance).driver;

        logger.error("Test failed: {}", result.getName());
        ScreenshotUtils.attachScreenshot(driver);
        String logPath = ((BaseTest) result.getInstance()).logFilePath;
        attachLog(logPath);
    }

    @Attachment(value = "Execution Log", type = "text/plain")
    public byte[] attachLog(String path) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
            return ("Unable to read log file: " + path).getBytes();
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String logPath = ((BaseTest) result.getInstance()).logFilePath;
        attachLog(logPath);
    }
}
