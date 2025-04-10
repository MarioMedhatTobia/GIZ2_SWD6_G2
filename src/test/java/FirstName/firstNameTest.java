package FirstName;

import Pages.FirstnameCheck;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class firstNameTest {

    final FirstnameCheck FirstName = new FirstnameCheck();
    @org.testng.annotations.Test(priority = 3)

    public void FirstnameSubmit(){
        FirstName.Firstname();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement ErrormaessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='field-validation-error']")));
        String Error = ErrormaessageElement.getText();
        System.out.println(Error);
        Assert.assertEquals("First name is required.",Error);
    }
}
