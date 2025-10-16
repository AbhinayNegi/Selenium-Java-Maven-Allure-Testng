package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);


    private final By BTN_ADD_REMOVE = By.xpath("//a[text()='Add/Remove Elements']");
    private final By LOGIN_HEADING = By.xpath("//h1");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking the add/remove button")
    public void clickAdd() {
        logger.info("Clicking add/remove button");
        clickElement(BTN_ADD_REMOVE);
    }

    @Step("Getting homepage heading text")
    public String getHomePageHeading() {
        logger.info("Getting homepage heading text");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_HEADING)).getText();
    }
}
