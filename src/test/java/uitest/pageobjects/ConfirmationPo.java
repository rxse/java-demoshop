// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

// Additional data: {"img":"screenshots/ba2feca6-6a26-8c7b-94dc-d8933d8fb851.png"}
public class ConfirmationPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    // Additional data:
    // {"img":"screenshots/886bef07-0ca2-c9d2-46e0-b2e19064fe80.png"}
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
        String totalAmountText = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.totalAmount))
                .getText();

        return totalAmountText;
    }
}
