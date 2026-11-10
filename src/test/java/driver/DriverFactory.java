package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public WebDriver createDriver(){
        WebDriver driver = new ChromeDriver();

        return driver;

    }

}
