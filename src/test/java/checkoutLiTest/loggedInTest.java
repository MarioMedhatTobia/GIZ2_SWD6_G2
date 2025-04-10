package checkoutLiTest;

import Pages.checkOutLoggedin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class loggedInTest {

    final checkOutLoggedin Loggedin = new checkOutLoggedin();

    @org.testng.annotations.Test(priority = 2)

    public void LoggedIn(){
        Loggedin.checkOutLoggedIn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']")));
        String Success = successMessageElement.getText();
        System.out.println(Success);
        Assert.assertEquals("Your order has been successfully processed!",Success);
    }
}
