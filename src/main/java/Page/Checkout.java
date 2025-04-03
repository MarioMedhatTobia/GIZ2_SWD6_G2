package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



import static Utilities.selenium.DriverFactory.driver;

import static Utilities.selenium.DriverFactory.driver;

public class Checkout {

    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
    private By billingButtonContainer = By.id("billing-buttons-container");

//    public void ValidCheckout() {

        public ValidCheckout(WebDriver driver); {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        }



        driver.get("https://demowebshop.tricentis.com/onepagecheckout");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys(Constant.CompanyAddress);
//driver.findElement(By.xpath("button-1 new-address-next-step-button")).click();
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("Egypt");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys(Constant.City);
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys(Constant.HomeAddress);
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys(Constant.ZipCode);
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys(Constant.Phone);
        wait.until(ExpectedConditions.elementToBeClickable(billingButtonContainer));
        driver.findElement(billingButtonContainer).sendKeys(Keys.ENTER);

    }
}
