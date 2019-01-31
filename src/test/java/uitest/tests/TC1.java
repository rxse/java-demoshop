// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.pageobjects.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

class TC1 extends TestNgTestBase {
    @Test
    public void checkForTotalAmountUsing3Items() {
        WebDriver driver = getDriver();
        // No setup code needed - {@link TestNgTestBase} creates the driver instance

        // Open the page
        ItemsOverviewPo overview = new ItemsOverviewPo(driver).open("https://demoshop.webtestit.com/");

        // Add items to the cart
        overview.addItem1ToCart().addItem2ToCart().addItem3ToCart();

        // Perform checkout
        CheckoutPo checkout = new HeaderPo(driver).proceedToCheckout();

        // Fill out form and place order
        ConfirmationPo confirmation = checkout.setFirstName("Chuck").setSecondName("Norris")
                .setEmail("chuck.norries@test.com").placeOrder();

        // Assert that the ordered amount is correct
        Assert.assertEquals(confirmation.getTotalAmount(), "€3,700.00");

        // No tear down code needed - {@link TestNgTestBase} takes care of the cleanup
    }

    @Test
    public void checkForTotalAmountUsing1Item() {
        WebDriver driver = getDriver();
        // No setup code needed - {@link TestNgTestBase} creates the driver instance

        // Open the page
        new ItemsOverviewPo(driver).open("https://demoshop.webtestit.com/").addItem1ToCart();

        // Perform checkout
        CheckoutPo checkout = new HeaderPo(driver).proceedToCheckout();

        // Fill out form and place order
        ConfirmationPo confirmation = checkout.setFirstName("Chuck").setSecondName("Norris")
                .setEmail("chuck.norries@test.com").placeOrder();

        // Assert that the ordered amount is correct
        Assert.assertEquals(confirmation.getTotalAmount(), "€1,500.00");

        // No tear down code needed - {@link TestNgTestBase} takes care of the cleanup
    }
}
