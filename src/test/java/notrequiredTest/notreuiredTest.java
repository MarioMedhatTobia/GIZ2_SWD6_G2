package notrequiredTest;

import Pages.notrequiredField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.Selenium.DriverFactory.driver;

public class notreuiredTest {

    final notrequiredField notRequired = new notrequiredField();
    @org.testng.annotations.Test(priority = 4)

    public void checkWithoutCompany(){
        notRequired.notrequiredMeth();
        String errorMessage = "Company is a required field";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement shippingMethod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Select a shipping address from your address book o')]")));
        String nextStep = shippingMethod.getText();
        Assert.assertNotEquals(errorMessage,nextStep,"Values should not be equal");
    }


}
