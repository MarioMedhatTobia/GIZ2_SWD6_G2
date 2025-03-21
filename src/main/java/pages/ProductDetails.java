package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class ProductDetails {
    public void changeProductQuantityInvalid(){
        driver.findElement(By.xpath("//img[@alt='Tricentis Demo Web Shop']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Build your own cheap computer']")).click();
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).clear();
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).sendKeys("0");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']")).click();
    }
    public void changeProductQuantityToZeroInCart(){
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).clear();
        driver.findElement(By.xpath("//input[@id='addtocart_72_EnteredQuantity']")).sendKeys("999");
        driver.findElement(By.xpath("//input[@id='add-to-cart-button-72']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[@class='content']")));
        driver.findElement(By.cssSelector("a[class='ico-cart'] span[class='cart-label']")).click();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).clear();
        driver.findElement(By.xpath("//input[contains(@name, 'itemquantity')]")).sendKeys("0");
        driver.findElement(By.xpath("//input[@name='updatecart']")).click();
    }
}
