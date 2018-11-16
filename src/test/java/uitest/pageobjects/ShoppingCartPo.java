// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ShoppingCartPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    private By viewCartButton = By.cssSelector(".woocommerce-mini-cart__buttons .wc-forward:nth-of-type(1)");
    private By checkOutButton = By.cssSelector(".checkout");

    // Constructor
    public ShoppingCartPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public ShoppingCartPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public CartPo clickOnViewCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.viewCartButton)).click();

        return new CartPo(this.driver);
    }

    public CheckoutPo clickOnCheckout() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.checkOutButton)).click();

        return new CheckoutPo(this.driver);
    }
}
