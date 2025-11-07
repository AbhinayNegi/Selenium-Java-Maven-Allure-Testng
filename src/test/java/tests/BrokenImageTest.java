package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.ExcelUtility;

import java.io.IOException;

public class BrokenImageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BrokenImageTest.class);

    public BrokenImageTest(   ) {
    }

    @Test
    @Description("Verify user can verify broken images")
    public void brokenImages() throws InterruptedException, IOException {
        try {
            logger.info("The user is on homepage");
            String homepageHeading = homePage.getHomePageHeading();
            Assert.assertEquals(homepageHeading, "Welcome to the-internet");
            homePage.clickBrokenImageButton();
            Assert.assertTrue(brokenImapgePage.verifyImage1isBroken());
            Assert.assertTrue(brokenImapgePage.verifyImage2isBroken());
            logger.info("Test passed");
        } catch (Exception e) {
            logger.error("Test failed -> {}", e.getMessage());
            throw e;
        } catch (AssertionError e) {
            logger.error("Test failed due to assertion error -> {}", e.getMessage());
            throw e;
        }
    }
}

