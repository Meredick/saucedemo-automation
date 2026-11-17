package steps;

import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductsPage;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ProductsSteps {

    private TestContext testContext;
    private ProductsPage productsPage;
    private LoginPage loginPage;

    public ProductsSteps(TestContext testContext) {
        this.testContext = testContext;
    }


    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage = new LoginPage(testContext.getDriver());
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage = new ProductsPage(testContext.getDriver());
    }

    @Then("the product list should contain {int} products")
    public void theProductListShouldContainProducts(int expectedProductsCount) {
        int actualProductCount = productsPage.getProductCount();

        Assertions.assertEquals(
                expectedProductsCount,
                actualProductCount,
                "The product amount does not match the expected number of products");

    }

    @And("all products should display a name")
    public void allProductsShouldDisplayAName() {
        List<String> productNames = productsPage.getProductNames();

        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        6,
                        productNames.size(),
                        "The number of product names does not match the expected number of products"),

                () -> {
                    for (String name: productNames) {
                        Assertions.assertFalse(
                                name.isBlank(),
                                "Product name should not be blank"
                        );
                    }
                }
        );
    }

    @And("all products should display a price")
    public void allProductsShouldDisplayAPrice() {
        List<String> productPrices = productsPage.getProductPrices();

        Assertions.assertAll(
                () -> Assertions.assertEquals(6,
                        productPrices.size(),
                        "The number of product price does not match the expected number of products"),

                () -> {
                    for (String price: productPrices) {
                        Assertions.assertFalse(
                                price.isBlank(),
                                "Product price should not be blank"
                        );
                    }
                }



        );
    }

    @When("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String productName) {

        productsPage.addToCart(productName);

    }

    @Then("the cart counter should display {int}")
    public void theCartCounterShouldDisplay(int expectedCount) {

        int actualCount = Integer.parseInt(productsPage.getBadgeCount());

        Assertions.assertEquals(
                expectedCount,
                actualCount,
                "The cart amount does not match the expected number of products");
    }


    @And("the product {string} button should display {string}")
    public void theProductButtonShouldDisplay(String itemName, String expectedButtonText) {

        String actualButtonText = productsPage.getProductButtonText(itemName);

        Assertions.assertEquals(
                expectedButtonText,
                actualButtonText,
                "The product button text does not match the expected button text"
        );

    }
}
