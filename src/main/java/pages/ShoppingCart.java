package pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;

import static Utilities.selenium.DriverFactory.driver;

public class ShoppingCart {
    public void removeFeaturedProductFromCart(){
        driver.get("https://demowebshop.tricentis.com");
        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.xpath("//input[@name='updatecart']")).click();
    }
}
