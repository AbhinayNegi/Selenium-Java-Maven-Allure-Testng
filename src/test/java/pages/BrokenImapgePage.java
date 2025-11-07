package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrokenImapgePage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(BrokenImapgePage.class);

    private final By IMAGE_1 = By.xpath("(//img[@src='asdf.jpg'])[1]");
    private final By IMAGE_2 = By.xpath("(//img[@src='img/avatar-blank.jpg'])[1]");
    private final By LOGIN_HEADING = By.xpath("//h5");

    public BrokenImapgePage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyImage1isBroken() {
        logger.info("Verify if image1 is broken");
        WebElement imageElement = driver.findElement(IMAGE_1);
        // Get the naturalWidth attribute
        String width = imageElement.getAttribute("naturalWidth");
        logger.info("Image naturalWidth: {}", width);
        // Convert to integer
        int widthValue = Integer.parseInt(width);
        if (widthValue >= 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean verifyImage2isBroken(){
        logger.info("Verify if image2 is broken");
        WebElement imageElement = driver.findElement(IMAGE_2);
        // Get the naturalWidth attribute
        String width2 = imageElement.getAttribute("naturalWidth");
        logger.info("Image naturalWidth: {}", width2);
        // Convert to integer
        int widthValue = Integer.parseInt(width2);
        if (widthValue >= 0) {
            return true;
        } else {
            return false;
        }

    }

}
