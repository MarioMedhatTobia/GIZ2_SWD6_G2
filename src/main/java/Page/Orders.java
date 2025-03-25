package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import static Utilities.selenium.DriverFactory.driver;

public class Orders {
    public void ValidOrder () {
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/customer/orders']")).click();
    }
}
