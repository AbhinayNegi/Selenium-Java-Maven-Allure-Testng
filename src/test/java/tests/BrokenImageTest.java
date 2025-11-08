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
            try {
                Assert.assertTrue(brokenImapgePage.verifyImage1isBroken(), "Image is broken!");
            }  catch (AssertionError e) {
            logger.error("Image 1 is broken: {}", e.getMessage());
        }
            try {
                Assert.assertTrue(brokenImapgePage.verifyImage2isBroken(), "Image is broken!");
            }  catch (AssertionError e) {
                logger.error("Image 2 is broken: {}", e.getMessage());
            }
            logger.info("Verification completed for both images");
        } catch (Exception e) {
            logger.error("Test failed due to unexpected error -> {}", e.getMessage());
            throw e;
        }
        }
}

