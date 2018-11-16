// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ItemsOverviewPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    private By item1AddToCartButton = By.cssSelector("[href=\"\\/\\?add-to-cart\\=8\"]");
    private By item2AddToCartButton = By.cssSelector("[href=\"\\/\\?add-to-cart\\=9\"]");
    private By item3AddToCartButton = By.cssSelector("[href=\"\\/\\?add-to-cart\\=10\"]");
    private By item1ViewCartButton = By.cssSelector(
            "[class=\"post-8 product type-product status-publish has-post-thumbnail product_cat-uncategorized first instock downloadable virtual purchasable product-type-simple\"] .added_to_cart");
    private By item2ViewCartButton = By.cssSelector(
            "[class=\"post-9 product type-product status-publish has-post-thumbnail product_cat-uncategorized  instock shipping-taxable purchasable product-type-simple\"] .added_to_cart");
    private By item3ViewCartButton = By.cssSelector(
            "[class=\"post-10 product type-product status-publish has-post-thumbnail product_cat-uncategorized last instock downloadable virtual purchasable product-type-simple\"] .added_to_cart");

    // Constructor
    public ItemsOverviewPo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public ItemsOverviewPo open(String url) {
        this.driver.get(url);

        return this;
    }

    // Generated actions
    public ItemsOverviewPo addItem1ToCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item1AddToCartButton)).click();

        WebElement item1ViewCartButtonElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item1ViewCartButton));

        return this;
    }

    public ItemsOverviewPo addItem2ToCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item2AddToCartButton)).click();

        WebElement item2ViewCartButtonElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item2ViewCartButton));

        return this;
    }

    public ItemsOverviewPo addItem3ToCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item3AddToCartButton)).click();

        WebElement item3ViewCartButtonElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item3ViewCartButton));

        return this;
    }

    public CartPo clickOnCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item3ViewCartButton)).click();

        return new CartPo(this.driver);
    }
}
