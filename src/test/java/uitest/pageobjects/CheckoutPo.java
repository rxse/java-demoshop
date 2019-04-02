// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

// Additional data: {"img":"screenshots/a2a21006-4c03-4662-082d-4679fa54e834.png"}
public class CheckoutPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    // Additional data:
    // {"img":"screenshots/11f06113-3eca-5557-a9e7-76bf32e029a4.png"}
    private By firstNameField = By.cssSelector("[autocomplete='given-name']");
    // Additional data:
    // {"img":"screenshots/a47f4bf9-2ad1-7f24-b336-899d89b69ef5.png"}
    private By secondNameField = By.cssSelector("[autocomplete='family-name']");
    // Additional data:
    // {"img":"screenshots/a27bbe5a-9f62-9cc2-aa35-0eedf24a8b08.png"}
    private By emailField = By.cssSelector("[autocomplete='email username']");
    // Additional data:
    // {"img":"screenshots/5825e955-ff8d-102b-453a-e4cc9da1b070.png"}
    private By placeOrderButton = By.cssSelector("[value='Place order']");
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

        /*
         * The demo shop uses a UI-Overlay after validating the form, so we wait for the
         * blocker to disappear before clicking the place order button. It eventually
         * raise a StaleElementReferenceException, cause the overlay gets removed from
         * the DOM.
         */
        try {
            this.wait.until(ExpectedConditions.invisibilityOfElementLocated(this.blocker));
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
        }

        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.placeOrderButton)).click();

        return new ConfirmationPo(this.driver);
    }
}
