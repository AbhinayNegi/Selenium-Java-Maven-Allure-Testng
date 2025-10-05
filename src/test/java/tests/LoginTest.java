package tests;

import io.qameta.allure.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExcelUtility;

import java.io.IOException;

public class LoginTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Test
    @Description("Verify user can login")
    public void loginUser() throws InterruptedException, IOException {
        try {
            Object[][] loginData = ExcelUtility.getData("src/test/resources/LoginData.xlsx", "Sheet1");
            Assert.assertNotNull(loginData);
            String username = loginData[0][0].toString();
            String password = loginData[0][1].toString();

            logger.info("Test login user has started");
            String loginHeading = loginPage.getLoginPageHeading();
            Assert.assertEquals(loginHeading, "Login");

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            Assert.assertTrue(dashboardPage.isDashboardHeadingVisible());
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
