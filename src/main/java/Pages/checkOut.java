package Pages;

import Utilities.Selenium.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class checkOut {

    public void checkOut() {

        //Open browser
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.findElement(By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']")).click();
        driver.findElement(By.xpath("//h2[@class='product-title']//a[normalize-space()='Computing and Internet']")).click();
        driver.findElement(By.cssSelector("#add-to-cart-button-13")).click();

        // wait until shopping cart pop-up
        WebElement popupLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='shopping cart']")));
        popupLink.click();

        driver.findElement(By.cssSelector("#termsofservice")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        driver.findElement(By.xpath("//input[@value='Checkout as Guest']")).click();

        // Checkout process
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("John");//First name
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Doe");//Last name
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("demoweb@pokemail.net");//Email
        driver.findElement(By.id("BillingNewAddress_Company"));//Company
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("France");//Country dropdown
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Paris");//city
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("t113 Avenue Jean Monnet");//Address1
        driver.findElement(By.id("BillingNewAddress_Address2")).sendKeys("Bouches-du-Rhône");//Address2
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("13127");//Postal code
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("04 42 75 02 03");//Phone no
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("43.426719");//Fax no
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
