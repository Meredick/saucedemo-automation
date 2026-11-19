package steps;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutPage;

public class CheckoutSteps {

    private final TestContext testContext;
    private CheckoutPage checkoutPage;

    public CheckoutSteps(TestContext testContext) {
        this.testContext = testContext;
    }



    @And("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        checkoutPage = new CheckoutPage(testContext.getDriver());
        checkoutPage.continueToCheckout();
    }

    @And("the user enters valid checkout information")
    public void theUserEntersValidCheckoutInformation() {
        checkoutPage.fillCheckoutForm("Marie", "Smith", "33166");
    }

    @Then("the user should be directed to the checkout overview page")
    public void theUserShouldBeDirectedToTheCheckoutOverviewPage() {

        Assertions.assertTrue(
                checkoutPage.isCheckoutOverviewDisplayed(),
                "The checkout overview page is not displayed"
        );
    }

    @And("the user enters checkout information with an empty {string}")
    public void theUserEntersCheckoutInformationWithAnEmpty(String field) {

        checkoutPage.enterCheckoutInformationWithEmptyField(field);
    }

    @Then("the user should see the checkout error {string}")
    public void theUserShouldSeeTheCheckoutError(String expectedErrorMessage) {

        String actualErrorMessage = checkoutPage.getErrorMessage();

        Assertions.assertEquals(expectedErrorMessage,
                actualErrorMessage,
                "The actual checkout error message is not equal to the expected error message");

    }

    @Then("the checkout overview should display the product {string}")
    public void theCheckoutOverviewShouldDisplayTheProduct(String expectedProductName) {
        String actualName = checkoutPage.getCheckoutProductNames().get(0);

        Assertions.assertEquals(expectedProductName,
                actualName,
                "The checkout product name is not equal to the expected product name");

    }

    @And("the checkout overview should display the correct quantity and price")
    public void theCheckoutOverviewShouldDisplayTheCorrectQuantityAndPrice() {

        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "$29.99",
                        checkoutPage.getCheckoutProductPrices().get(0),
                        "The checkout product price is not equal to the expected product price"
                ),

                () -> Assertions.assertEquals(
                        "1",
                        checkoutPage.getCheckoutProductQuantities().get(0),
                        "The checkout product quantity is not equal to the expected quantity"
                )
        );

    }

    @And("the user completes the order")
    public void theUserCompletesTheOrder() {
        checkoutPage.finishOrder();

    }


    @Then("the user should see the order confirmation message {string}")
    public void theUserShouldSeeTheOrderConfirmationMessage(String expectedMessage) {
        String actualMessage = checkoutPage.getSuccessMessage();

        Assertions.assertEquals(expectedMessage,
                actualMessage,
                "The actual order confirmation message is not equal to the expected order message");
    }
}
