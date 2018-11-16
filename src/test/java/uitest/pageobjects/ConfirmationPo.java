// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ConfirmationPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    private By totalAmount = By.cssSelector(".woocommerce-order ul .woocommerce-Price-amount");

    // Constructor
    public ConfirmationPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public ConfirmationPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public String getTotalAmount() {
        String totalAmountText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.totalAmount)).getText();

        return totalAmountText;
    }
}
