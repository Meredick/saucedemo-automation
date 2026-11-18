package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private final By cartButton = By.cssSelector("[data-test='shopping-cart-link']");
    private final By cartList = By.cssSelector("[data-test='cart-list']");
    private final By cartItem = By.cssSelector("[data-test='inventory-item']");
    private final By cartProductName = By.cssSelector("[data-test='inventory-item-name']");
    private final By cartProductPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By removeButton = By.cssSelector("button");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart(){
        click(cartButton);
    }

    public List<String> getCartProductNames(){
        List<WebElement> cartItems = findElements(cartItem);
        List<String> productNames = new ArrayList<>();

        for(WebElement item : cartItems){
            productNames.add(item.findElement(cartProductName).getText());
        }

        return productNames;
    }

    public List<String> getCartProductPrices(){
        List<WebElement> cartItems = findElements(cartItem);
        List<String> productPrices = new ArrayList<>();

        for(WebElement item : cartItems){
            productPrices.add(item.findElement(cartProductPrice).getText());
        }

        return productPrices;
    }

    public void removeProduct(String productName){
        List<WebElement> cartItems = findElements(cartItem);

        for(WebElement item : cartItems){
            if(item.findElement(cartProductName).getText().equals(productName)){
                WebElement button = item.findElement(removeButton);
                button.click();
                break;
            }
        }
    }

    public boolean isCartEmpty()
        {
        List<WebElement> cartItems = findElements(cartItem);

        return cartItems.isEmpty();

        }


}
