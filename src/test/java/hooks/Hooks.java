package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import context.TestContext;

import java.sql.Driver;

public class Hooks {

    private final TestContext testContext;
    private final DriverFactory factory = new DriverFactory();

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp(){
        WebDriver driver = factory.createDriver();
        testContext.setDriver(driver);

    }

    @After
    public void tearDown(){
      if (testContext.getDriver() != null) {
          testContext.getDriver().quit();
      }

    }
}
