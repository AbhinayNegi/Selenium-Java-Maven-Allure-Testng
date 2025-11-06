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


    public Authpage(WebDriver driver) {
        super(driver);
    }

     @Step("Verify user can enter username and passowrd in the alert")
     public void handleAuthAlert(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
     }

     // This could be used for the  prompts/alerts if they were inside the DOM
//    @Step("Verify user can enter username and passowrd in the alert")
//    public void handleAuthAlert(){
//    Alert myalert= driver.switchTo().alert();
//    myalert.sendKeys("admin");
//    myalert.sendKeys("admin");
//    myalert.accept();
//    }
//
    @Step("Verify basic auth text is visible")
    public String getBasicAuthTextVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(AUTH_TEXT)).getText();
    }


}
