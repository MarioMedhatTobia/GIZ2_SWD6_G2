package registrationTest;

import Pages.Login;
import Pages.Logout;
import Pages.Registration;
import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class RegistrationTest {

    private Registration register;

    @BeforeMethod
    public void setUp(){
       driver = DriverFactory.getDriver();
        register = new Registration();


    }



    //final Registration register = new Registration();

 /* @org.testng.annotations.Test(priority = 2)
  public void registrationWithAllBlankFieldsTest() throws InterruptedException {
      register.registrationWithAllBlankFields();}*/



    @org.testng.annotations.Test(priority = 1)
    public void registrationWithValidCredentialsTest(){
        register.registrationWithValidCredentials();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        //String confirmationMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]")).getText();
        //Assert.assertEquals("Your registration completed",confirmationMessage);
        //WebElement confirmationMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]")));
        //String expectedMessage = "Your registration completed";
        //String actualMessage = confirmationMessage1.getText();
        //Assert.assertEquals(actualMessage,expectedMessage,"Registration confirmation message is incorrect");
        WebElement confirmationMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]")));
        Assert.assertTrue(confirmationMessage1.isDisplayed(),"Registration confirmation message is not displayed");
        String confirmationMessage = confirmationMessage1.getText();
        System.out.println("Registration success message : " + confirmationMessage);
    }
    @org.testng.annotations.Test(priority = 3)
    public void registrationWithRegisteredEmailTest(){
        register.registrationWithRegisteredEmail();
        String errorMessage = driver.findElement(By.cssSelector("div[class='validation-summary-errors'] ul li")).getText();
        Assert.assertEquals("The specified email already exists" , errorMessage);
        System.out.println("Result = " + errorMessage);
    }
   @AfterMethod
   public void Close_Driver(){
       driver.close();
   }


}
