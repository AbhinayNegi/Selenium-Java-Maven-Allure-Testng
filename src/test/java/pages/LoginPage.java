package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private final By BTN_LOGIN = By.xpath("//button");
    private final By TF_USERNAME = By.xpath("//input[@name='username']");
    private final By TF_PASSWORD = By.xpath("//input[@name='password']");
    private final By LOGIN_HEADING = By.xpath("//h5");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering user name in the field")
    public void enterUsername(String username) {
        logger.info("Entering user name: {}", username);
        enterText(TF_USERNAME, username);
    }

    @Step("Entering password in the field")
    public void enterPassword(String password) {
        logger.info("Entering password: {}", password);
        enterText(TF_PASSWORD, password);
    }

    @Step("Clicking log in button")
    public void clickLogin() {
        logger.info("Clicking login button");
        clickElement(BTN_LOGIN);
    }

    public String getLoginPageHeading() {
        logger.info("Getting login heading text");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADING)).getText();
    }


}
