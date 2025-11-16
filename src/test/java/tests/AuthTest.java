package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import java.io.IOException;

public class AuthTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(AuthTest.class);

    @Test
    @Description("Verify user can enter username and password in the propmt")
    public void Authpage() throws InterruptedException, IOException {
        try {
            logger.info("The user is on homepage");
            String homepageHeading = homePage.getHomePageHeading();
            Assert.assertEquals(homepageHeading, "Welcome to the-internet");
            logger.info("The user is handeling the auth");
            authPage.handleAuthAlert();
            String AuthHeading = authPage.getBasicAuthTextVisible();
            Assert.assertEquals(AuthHeading, "Basic Auth");
            logger.info("The user is handeling the digest auth");
            authPage.handledigestAuthAlert();
            String DigestAuthHeading = authPage.getdigestAuthTextVisible();
            Assert.assertEquals(DigestAuthHeading, "Digest Auth");
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

