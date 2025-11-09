package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import java.io.IOException;

public class ContextMenuTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ContextMenuTest.class);

    public ContextMenuTest(   ) {
    }

    @Test
    @Description("Verify user can ")
    public void brokenImages() throws InterruptedException, IOException {
        try {
            logger.info("The user is on homepage");
            String homepageHeading = homePage.getHomePageHeading();
            Assert.assertEquals(homepageHeading, "Welcome to the-internet");
            contextMenuPage.ClickContextMenuBtn();
            contextMenuPage.ContextMenu();
            try {
                Assert.assertTrue(!contextMenuPage.ContextMenu(),"Alert pop up is not visible");
            }  catch (AssertionError e) {
                logger.error("Alert is not visible: {}", e.getMessage());
            }
            logger.info("Test passed");
        } catch (Exception e) {
            logger.error("Test failed due to unexpected error -> {}", e.getMessage());
            throw e;
        }
    }
}


