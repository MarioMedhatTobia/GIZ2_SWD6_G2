package loginTest;

import Page.Login;
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


    private Login login;
    @BeforeClass
    public void setUp(){
        login = new Login();
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

}
