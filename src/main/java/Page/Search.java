package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import static Utilities.selenium.DriverFactory.driver;

public class Search {
    public void ValidSearch () {
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("Super Mario");
    }
}
