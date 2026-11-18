package steps;

import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.LoginPage;

public class CartSteps {

    private final TestContext testContext;
    private CartPage cartPage;

    public CartSteps(TestContext testContext) {
        this.testContext = testContext;
    }


    @And("the user opens the shopping cart")
    public void theUserOpensTheShoppingCart() {
        cartPage = new CartPage(testContext.getDriver());
        cartPage.openCart();


    }

    @Then("the shopping cart should display the product {string}")
    public void theShoppingCartShouldDisplayTheProduct(String expectedProductName) {
        String actualProductName = cartPage.getCartProductNames().get(0);
        Assertions.assertEquals(
                expectedProductName,
                actualProductName,
                "The product name is incorrect.");
    }

    @And("the shopping cart should display the price {string}")
    public void theShoppingCartShouldDisplayThePrice(String expectedProductPrice) {
        String actualProductPrice = cartPage.getCartProductPrices().get(0);
        Assertions.assertEquals(
                expectedProductPrice,
                actualProductPrice,
                "The price is incorrect."
        );
    }

    @And("the user removes the product {string}")
    public void theUserRemovesTheProduct(String product) {
        cartPage.removeProduct(product);
    }

    @Then("the shopping cart should be empty")
    public void theShoppingCartShouldBeEmpty() {

        Assertions.assertTrue(cartPage.isCartEmpty(),
                "The shopping cart should be empty.");
    }
}
