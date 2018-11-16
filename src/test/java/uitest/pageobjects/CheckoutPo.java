// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CheckoutPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    private By firstNameField = By.cssSelector("#billing_first_name_field [type]");
    private By secondNameField = By.cssSelector("#billing_last_name_field [type]");
    private By emailField = By.cssSelector("[type=\"email\"]");
    private By placeOrderButton = By.cssSelector(".place-order button");
    private By blocker = By.cssSelector(".blockOverlay");

    // Constructor
    public CheckoutPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public CheckoutPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public CheckoutPo setFirstName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.firstNameField)).sendKeys(text);

        return this;
    }

    public CheckoutPo setSecondName(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.secondNameField)).sendKeys(text);

        return this;
    }

    public CheckoutPo setEmail(String text) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.emailField)).sendKeys(text);

        return this;
    }

    public ConfirmationPo placeOrder() {

        /* The demo shop uses a UI-Overlay after validating the form,
           so we wait for the blocker to disappear before clicking the place order button.
           It eventually raise a StaleElementReferenceException, cause the overlay gets removed from the DOM.
        */
        try {
            this.wait.until(ExpectedConditions.invisibilityOfElementLocated(this.blocker));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        }

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.placeOrderButton)).click();

        return new ConfirmationPo(this.driver);
    }
}
