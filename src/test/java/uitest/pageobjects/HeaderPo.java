// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HeaderPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    private By checkOutButton = By.cssSelector("#site-navigation .menu:nth-child(2) [href=\"https\\:\\/\\/demoshop\\.webtestit\\.com\\/checkout\\/\"]");

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
