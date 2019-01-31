// Ranorex Webtestit Test File

package uitest.tests;

import uitest.TestNgTestBase;
import uitest.pageobjects.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

class TC2 extends TestNgTestBase {
    @Test
    public void checkForTotalAmountUsingFastCheckout() {
        WebDriver driver = getDriver();
        // No setup code needed - {@link TestNgTestBase} creates the driver instance

        // Open the page
        ItemsOverviewPo overview = new ItemsOverviewPo(driver).open("https://demoshop.webtestit.com/");

        // Add items to the cart
        CartPo cart = overview.addItem1ToCart().addItem2ToCart().addItem3ToCart().clickOnCart();

        // Perform checkout
        CheckoutPo checkout = cart.proceedToCheckout();

        // Fill out form and place order
        ConfirmationPo confirmation = checkout.setFirstName("Chuck").setSecondName("Norris")
                .setEmail("chuck.norries@test.com").placeOrder();

        // Assert that the ordered amount is correct
        Assert.assertEquals(confirmation.getTotalAmount(), "€3,700.00");

        // No tear down code needed - {@link TestNgTestBase} takes care of the cleanup
    }
}
