package Pages;

import Utilities.Selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class checkOutLoggedin {
    public void checkOutLoggedIn() {

        //Open browser
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login
        driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
        driver.findElement(By.id("Email")).sendKeys("test0@sharklasers.com");
        driver.findElement(By.id("Password")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        //add item to the cart
        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")).click();
        driver.findElement(By.cssSelector("#add-to-cart-button-13")).click();

        // wait until shopping cart pop-up
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='shopping cart']"))).click();

        driver.findElement(By.cssSelector("#termsofservice")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        // Checkout process
        driver.findElement(By.cssSelector("input[onclick='Billing.save()']")).click();

        //shipping address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#PickUpInStore"))).click();
        driver.findElement(By.cssSelector("input[onclick='Shipping.save()']")).click();

        //Payment method
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#paymentmethod_0")));
        driver.findElement(By.cssSelector("input[class='button-1 payment-method-next-step-button']")).click();

        //payment info
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='button-1 payment-info-next-step-button']"))).click();

        //Confirmation
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Confirm']"))).click();

    }
}
