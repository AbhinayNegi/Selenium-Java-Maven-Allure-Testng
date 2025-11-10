package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

public class Authpage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private final By AUTH_TEXT = By.xpath("//h3[text()='Basic Auth']");
    private final By DIGEST_AUTH_TEXT= By.xpath("//h3[text()='Digest Auth']");


    public Authpage(WebDriver driver) {
        super(driver);
    }

     @Step("Verify user can enter username and passowrd in the alert")
     public void handleAuthAlert(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
     }

    @Step("Verify basic auth text is visible")
    public String getBasicAuthTextVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AUTH_TEXT)).getText();
    }

    @Step("Verify user can enter username and passowrd in the digest auth alert")
    public void handledigestAuthAlert(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
    }

    @Step("Verify digest auth text is visible")
    public String getdigestAuthTextVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(DIGEST_AUTH_TEXT)).getText();
    }
}
