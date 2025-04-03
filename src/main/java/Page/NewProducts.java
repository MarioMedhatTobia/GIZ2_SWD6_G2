package Page;


import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import static Utilities.selenium.DriverFactory.driver;


public class NewProducts {

    public void ClickNewProducts () {
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/newproducts']")).click();

    }

}