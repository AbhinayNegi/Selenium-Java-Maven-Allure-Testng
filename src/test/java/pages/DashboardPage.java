package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends BasePage{

    private final By DASHBOARD_HEADING = By.xpath("//button");
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardHeadingVisible() {
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(DASHBOARD_HEADING)).isDisplayed();
    }
}
