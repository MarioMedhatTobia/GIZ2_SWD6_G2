package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import static Utilities.selenium.DriverFactory.*;

public class Checkout {

    private WebDriver driver;
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    //Locators

    public void ValidCheckout() {


        driver = DriverFactory.driver;
        driver.get("https://demowebshop.tricentis.com/onepagecheckout");
//        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys(Constant.CompanyAddress);
////driver.findElement(By.xpath("button-1 new-address-next-step-button")).click();
//        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("Egypt");
//        driver.findElement(By.id("BillingNewAddress_City")).sendKeys(Constant.City);
//        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(Constant.HomeAddress);
//        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(Constant.ZipCode);
//        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(Constant.Phone);
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@onclick='Billing.save()']")));
//        driver.findElement(By.id("billing-buttons-container")).click();
        driver.findElement(By.cssSelector("input[onclick='Billing.save()']")).click();


    }
}
