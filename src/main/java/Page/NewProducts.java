package Page;


import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static Utilities.selenium.DriverFactory.driver;


public class NewProducts {

    public void ClickNewProducts () {
       // driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/newproducts']")).click();

        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h2[1]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/div[1]/input[2]")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("a[class='ico-cart'] span[class='cart-label']")).click();
    }
    public void ClickNewProducts2 () {
        // driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@href='/newproducts']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/input[1]")).click();
        driver.findElement(By.cssSelector("a[class='ico-cart'] span[class='cart-label']")).click();


    }

}
