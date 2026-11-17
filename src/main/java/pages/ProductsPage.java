package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends BasePage{

    private final By productsContainer = By.cssSelector("[data-test='inventory-container']");
    private final By productItem = By.cssSelector("[data-test='inventory-item-description']");
    private final By productName = By.cssSelector("[data-test='inventory-item-name']");
    private final By productPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By addToCartButton = By.cssSelector("button");
    private final By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageDisplayed(){
        return driver.getCurrentUrl().contains("/inventory.html");

    }

    public int getProductCount(){
        return findElements(productItem).size();
    }

    public List<String> getProductNames(){
        List<WebElement> productElements = findElements(productName);
        List<String> productNames = new ArrayList<>();

        for (WebElement product : productElements) {
            String name = product.getText();
            productNames.add(name);

        }

        return productNames;
    }

    public List<String> getProductPrices(){
        List<WebElement> priceElements = findElements(productPrice);
        List<String> productPrices = new ArrayList<>();

        for (WebElement product : priceElements) {
            String price = product.getText();
            productPrices.add(price);
        }

        return productPrices;
    }

    public void addToCart(String itemName){
        List<WebElement> productItems = findElements(productItem);


        for (WebElement product : productItems) {
            String actualItemName = product.findElement(productName).getText();
            if (actualItemName.equals(itemName)) {
                WebElement addButton = product.findElement(addToCartButton);
                addButton.click();
                break;

            }
        }

    }

    public String getBadgeCount(){

        return getText(cartBadge);
    }

    public String getProductButtonText(String itemName){
        List<WebElement> productItems = findElements(productItem);

        for (WebElement product : productItems) {
            String actualItemName = product.findElement(productName).getText();

            if (actualItemName.equals(itemName)) {
                WebElement productButton = product.findElement(addToCartButton);

                return productButton.getText();
            }
        }

        throw new NoSuchElementException("Product not found: " + itemName);
    }


}
