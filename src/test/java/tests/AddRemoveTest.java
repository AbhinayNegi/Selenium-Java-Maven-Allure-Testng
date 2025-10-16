package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddRemoveTest extends BaseTest{
        private static final Logger logger = LoggerFactory.getLogger(AddRemoveTest.class);

        @Test
        @Description("Verify user can click add and remove button")
        public void clickAdd() throws InterruptedException, IOException {
        try {
            logger.info("The user is on homepage");
            String homepageHeading = homePage.getHomePageHeading();
            Assert.assertEquals(homepageHeading, "Welcome to the-internet");
            homePage.clickAdd();
            Assert.assertTrue(addRemovePage.isAddElementButtonVisible());
            logger.info("Test passed");
            addRemovePage.clickAddElement();
            Assert.assertTrue(addRemovePage.isDeleteElementButtonVisible());
            logger.info("Test passed");
            addRemovePage.clickDeleteElement();
            Assert.assertTrue(addRemovePage.isDeleteElementButtonInVisible());
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
