package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextMenuPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ContextMenuPage.class);

    private final By RIGHT_BTN = By.id("hot-spot");
    private final By CONTEXT_MENU_BTN = By.xpath("//a[text()='Context Menu']");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking context menu button")
    public void ClickContextMenuBtn() {
        logger.info("Clicking context menu button");
        clickElement(CONTEXT_MENU_BTN);
    }

    @Step("Clicking ok button on the alert")
    public boolean ContextMenu() {
        WebElement rightClickBtn = driver.findElement(RIGHT_BTN);
        // Create Actions instance
        Actions actions = new Actions(driver);
        // Perform right-click
        actions.contextClick(rightClickBtn).perform();
        // Handle alert popup
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        return true;
    }
}


