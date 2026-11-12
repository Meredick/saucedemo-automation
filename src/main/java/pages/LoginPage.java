package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private final By loginErrorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password){
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public void open(){
        navigateTo(LOGIN_URL);
    }

    public boolean isProductsPageDisplayed(){
        return driver.getCurrentUrl().contains("/inventory.html");

    }

    public String getErrorMessage(){
        return getText(loginErrorMessage);
    }

}
