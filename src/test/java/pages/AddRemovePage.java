package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.BaseTest;

public class AddRemovePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(AddRemovePage.class);

    private final By ADD_ELEMENT_BTN = By.xpath("//button");
    private final By DELETE_ELEMENT_BTN= By.xpath("//button[text()='Delete']");
    public AddRemovePage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify add element is visible")
    public boolean isAddElementButtonVisible() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(ADD_ELEMENT_BTN)).isDisplayed();
    }

    @Step("Clicking the add button")
    public void clickAddElement() {
        logger.info("Clicking add button");
        clickElement(ADD_ELEMENT_BTN);
    }

    @Step("Verify delete element is visible")
    public boolean isDeleteElementButtonVisible() {
            return wait.until(ExpectedConditions.
                    visibilityOfElementLocated(DELETE_ELEMENT_BTN)).isDisplayed();
    }

    @Step("Clicking the delete button")
    public void clickDeleteElement() {
        logger.info("Clicking delete button");
        clickElement(DELETE_ELEMENT_BTN);
    }

    @Step("Verify delete element is invisible")
    public boolean isDeleteElementButtonInVisible() {
        return wait.until(ExpectedConditions.
                invisibilityOfElementLocated(DELETE_ELEMENT_BTN));
    }
}
