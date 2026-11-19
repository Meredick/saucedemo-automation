package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends BasePage {

    private final By checkoutButton = By.id("checkout");
    private final By nameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By errorMessage = By.cssSelector("[data-test='error']");
    private final By productList = By.cssSelector("[data-test='cart-list']");
    private final By productName = By.cssSelector("[data-test='inventory-item-name']");
    private final By productPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By productQuantity = By.cssSelector("[data-test='item-quantity']");
    private final By finishButton = By.id("finish");
    private final By successMessage = By.cssSelector("[data-test='complete-header']");



    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void continueToCheckout()
    {
        click(checkoutButton);
    }

    public void fillCheckoutForm(String FirstName, String LastName, String ZipCode)
    {
        type(nameInput, FirstName);
        type(lastNameInput, LastName);
        type(zipCodeInput, ZipCode);
        click(continueButton);

    }


    public void enterCheckoutInformationWithEmptyField(String field) {

        if (field.equals("first name")) {
            type(nameInput, "");
            type(lastNameInput, "Last name");
            type(zipCodeInput, "Postal code");

        }
        else if (field.equals("last name")) {
            type(nameInput, "First name");
            type(lastNameInput, "");
            type(zipCodeInput, "Postal code");

        } else {
            throw new IllegalArgumentException("Unknown checkout field: " + field);
        }

        click(continueButton);


    }

    public Boolean isCheckoutOverviewDisplayed()
    {
        return driver.getCurrentUrl().contains("/checkout-step-two.html");
    }

    public String getErrorMessage()
    {
        return getText(errorMessage);

    }

    public List<String> getCheckoutProductNames(){
        List<WebElement> products = findElements(productList);
        List<String> productNames = new ArrayList<>();

        for(WebElement product : products){
            productNames.add(product.findElement(productName).getText());
        }

        return productNames;
    }

    public List<String> getCheckoutProductPrices(){
        List<WebElement> products = findElements(productList);
        List<String> productPrices = new ArrayList<>();

        for(WebElement product : products){
            productPrices.add(product.findElement(productPrice).getText());
        }

        return productPrices;
    }

    public List<String> getCheckoutProductQuantities(){
        List<WebElement> products = findElements(productList);
        List<String> productQuantities = new ArrayList<>();
        for(WebElement product : products){
            productQuantities.add(product.findElement(productQuantity).getText());
        }

        return productQuantities;
    }

    public void finishOrder()
    {
        click(finishButton);
    }

    public String getSuccessMessage(){
        return getText(successMessage);
    }



}
