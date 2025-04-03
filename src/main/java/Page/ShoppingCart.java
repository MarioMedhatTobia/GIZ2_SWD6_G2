package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import static Utilities.selenium.DriverFactory.driver;


public class ShoppingCart {

    //Valid buyer
    public void ValidBuyer () {
        //driver = DriverFactory.getDriver();
        //driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        // Agree on terms of service
        // In case there are items in the cart the code will run
        driver.findElement(By.id("termsofservice")).click();

        //click on submit button
        driver.findElement(By.id("checkout")).click();


    }

}