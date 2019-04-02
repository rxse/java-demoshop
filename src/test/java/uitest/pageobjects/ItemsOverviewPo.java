// Ranorex Webtestit Page Object File

package uitest.pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

// Additional data: {"img":"screenshots/5d3af393-89cf-3e76-814c-c41b2140fbf7.png"}
public class ItemsOverviewPo {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Generated elements
    // Additional data:
    // {"img":"screenshots/49616360-3826-2ab3-cffd-ded10189911e.png"}
    private By item1AddToCartButton = By.cssSelector("[data-product_id='8']");
    // Additional data:
    // {"img":"screenshots/c3947c2a-8045-41c4-89b3-a9851fd55008.png"}
    private By item2AddToCartButton = By.cssSelector("[data-product_id='9']");
    // Additional data:
    // {"img":"screenshots/4129d204-46bb-44ec-de52-c7ca6c9eff3f.png"}
    private By item3AddToCartButton = By.cssSelector("[data-product_id='10']");
    // Additional data:
    // {"img":"screenshots/b3b57cd4-96ab-7eeb-9817-4eddb3ecdda6.png"}
    private By item1ViewCartButton = By.cssSelector(
            "[class='post-8 product type-product status-publish has-post-thumbnail product_cat-uncategorized first instock downloadable virtual purchasable product-type-simple'] [title]");
    // Additional data:
    // {"img":"screenshots/2c660321-c4db-1fc5-38cd-247904720708.png"}
    private By item2ViewCartButton = By.cssSelector(
            "[class='post-9 product type-product status-publish has-post-thumbnail product_cat-uncategorized  instock shipping-taxable purchasable product-type-simple'] [title]");
    // Additional data:
    // {"img":"screenshots/86052c2d-301b-1534-c8ae-f6d0174b1130.png"}
    private By item3ViewCartButton = By.cssSelector(
            "[class='post-10 product type-product status-publish has-post-thumbnail product_cat-uncategorized last instock downloadable virtual purchasable product-type-simple'] [title]");

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

        WebElement item1ViewCartButtonElement = this.wait
                .until(ExpectedConditions.visibilityOfElementLocated(this.item1ViewCartButton));

        return this;
    }

    public ItemsOverviewPo addItem2ToCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item2AddToCartButton)).click();

        WebElement item2ViewCartButtonElement = this.wait
                .until(ExpectedConditions.visibilityOfElementLocated(this.item2ViewCartButton));

        return this;
    }

    public ItemsOverviewPo addItem3ToCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item3AddToCartButton)).click();

        WebElement item3ViewCartButtonElement = this.wait
                .until(ExpectedConditions.visibilityOfElementLocated(this.item3ViewCartButton));

        return this;
    }

    public CartPo clickOnCart() {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.item3ViewCartButton)).click();

        return new CartPo(this.driver);
    }
}
