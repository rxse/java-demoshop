// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

// Additional data: {"img":"screenshots/d4726e86-3c54-03a7-02ce-9ace76ffb472.png"}
public class CartPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    // Additional data:
    // {"img":"screenshots/a697f4d4-f632-34f5-e01f-2e560ad85237.png"}
    private By checkOutButton = By.cssSelector(".checkout-button");
    private By blocker = By.cssSelector(".blockUI .blockOverlay");

    // Constructor
    public CartPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public CartPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public CheckoutPo proceedToCheckout() {

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.checkOutButton)).click();

        /*
         * The demo shop uses a UI-Overlay to block the user from multiple button
         * clicks, so we wait for the blocker to disappear
         */
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(this.blocker));

        return new CheckoutPo(this.driver);
    }
}
