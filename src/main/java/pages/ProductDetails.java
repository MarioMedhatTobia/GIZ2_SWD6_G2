package pages;

import org.openqa.selenium.By;

import static Utilities.selenium.DriverFactory.driver;

public class ProductDetails {
    public void changeProductQuantityInvalid(){
        driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own cheap computer']")).click();
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).clear();
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).sendKeys("0");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']")).click();
    }
}
