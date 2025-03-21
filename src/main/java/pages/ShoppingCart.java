package pages;

import org.openqa.selenium.By;

import static Utilities.selenium.DriverFactory.driver;

public class ShoppingCart {
    public void changeProductQuantityValid(){
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).sendKeys("20");
        driver.findElement(By.xpath("//input[@name='updatecart']")).click();
    }
    public void removeProductFromCart(){
        driver.findElement(By.xpath("//span[normalize-space()='Shopping cart']")).click();
        driver.findElement(By.xpath("//input[@name='removefromcart']")).click();
        driver.findElement(By.xpath("//input[@name='updatecart']")).click();
    }

}
