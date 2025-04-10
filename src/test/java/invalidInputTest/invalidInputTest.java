package invalidInputTest;

import Pages.invalidInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class invalidInputTest {

    final invalidInput invalidInputvar = new invalidInput();
    @org.testng.annotations.Test(priority = 5)

    public void invalidEmail(){
        invalidInputvar.invalidInputMeth();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[for='BillingNewAddress_Email']")));
        String errorMessage = errorHandle.getText();
        System.out.println(errorMessage);
        Assert.assertEquals("Wrong email",errorMessage);
    }
}