package steps;
import context.TestContext;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginSteps {

    private final TestContext testContext;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("The user is on the login page")
    public void theUserIsOnTheLoginPage() {
        WebDriver driver = testContext.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();

    }


    @When("the user enters {string} as username and {string} as password")
    public void theUserEntersAsUsernameAndAsPassword(String userName, String password) {
        loginPage.login(userName, password);
    }

    @Then("the user should be directed to the products page")
    public void theUserShouldBeDirectedToTheProductsPage() {
        productsPage = new ProductsPage(testContext.getDriver());
        Assertions.assertTrue(productsPage.isProductsPageDisplayed(),
                "User was not redirected to the products page");
    }


    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String expectedErrorMessage) {
        System.out.println("EXPECTED MESSAGE: " + expectedErrorMessage);
        String actualMessage = loginPage.getErrorMessage();

       Assertions.assertEquals(
               expectedErrorMessage,
               actualMessage,
               "Expected message and actual message do not match"
       );
    }
}
