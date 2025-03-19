package loginTest;

import Pages.Login;
import Pages.Logout;
import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class LoginTest {

    private  Logout logout;
    private Login login;
    @BeforeClass
    public void setUp(){
        login = new Login();
        logout = new Logout();
        driver = DriverFactory.getDriver();

    }


    @org.testng.annotations.Test(priority = 1)
    public void loginWithValidCredentialsTest(){
        login.loginWithValidCredentials();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        String loginSuccess =driver.findElement(By.xpath("//a[@class='ico-logout']")).getText();
        Assert.assertEquals("Log out" , loginSuccess);
        System.out.println("Login Success Message : "+ loginSuccess);

    }
  @org.testng.annotations.Test(priority = 2)
   public void loginWithInvalidCredentials(){
       login.loginWithInvalidCredentials();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")));
        String errorMessage =driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]")).getText();
        Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again." , errorMessage);
        System.out.println("Login With Invalid Credentials Error Message : "+ errorMessage);

   }
   @org.testng.annotations.Test(priority = 3)
   public void verifyLoginCaseSensitiveTest(){
       login.verifyLoginCaseSensitive();
       String errorMessage2 =driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]")).getText();
       Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again." , errorMessage2);
       System.out.println("Case Sensitive Error Message : "+ errorMessage2);

   }
    @org.testng.annotations.Test(priority = 4)
    public void verifyForgetPasswordTest(){
        login.verifyForgetPassword();
        String passwordRecoveryMessage =driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]")).getText();
        Assert.assertEquals("Email with instructions has been sent to you." , passwordRecoveryMessage);
        System.out.println("Case Sensitive Error Message : "+ passwordRecoveryMessage);



    }


   @AfterClass
    public void Close_Driver(){
        driver.close();

   }
}
