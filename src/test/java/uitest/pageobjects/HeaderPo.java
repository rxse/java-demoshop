// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

// Additional data: {"img":"screenshots/1c0689e0-93dd-89c9-cac9-70ce65472c0c.png"}
public class HeaderPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    // Additional data:
    // {"img":"screenshots/00c26523-f8f9-ba64-f776-ba6ea4ae2c28.png"}
    private By checkOutButton = By
            .cssSelector(".nav-menu [href='https\\:\\/\\/demoshop\\.webtestit\\.com\\/checkout\\/']");

    // Constructor
    public HeaderPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public HeaderPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public CheckoutPo proceedToCheckout() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.checkOutButton)).click();

        return new CheckoutPo(this.driver);
    }
}
