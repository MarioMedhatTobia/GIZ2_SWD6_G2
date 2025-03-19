package logoutTest;

import Pages.Login;
import Pages.Logout;
import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;
import static Utilities.selenium.DriverFactory.getDriver;

public class LogoutTest {

     private  Logout logout;
    private Login login;
    @BeforeMethod
   public void setUp(){
        driver = DriverFactory.getDriver();
        login = new Login();
        logout = new Logout();
        login.loginWithValidCredentials();

   }

    @org.testng.annotations.Test(priority = 1)
    public void successLogoutTest(){
        logout.successLogout();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")));
        boolean isLoginDisplayed = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")).isDisplayed();
        Assert.assertTrue(isLoginDisplayed , "Test Failed : User is still logged in !");
        System.out.println("Test Passed : User successfully logged out ");

    }
   @org.testng.annotations.Test(priority = 2)
    public void VerifyUserCannotGoBackToRestrictedPagesLogoutTest() throws InterruptedException {
        logout.addToCart();
        String cartCount = logout.getCartQuantity();
        System.out.println("Current cart quantity : " + cartCount);
        Assert.assertNotEquals(cartCount , "(0)" , "Test Failed : cart quantity is still (0)!");
        logout.accessRestrictedPages();
       String currentUrl = driver.getCurrentUrl();
       System.out.println("Current Url after navigation back : " + currentUrl);
       Assert.assertNotEquals(currentUrl ,("https://demowebshop.tricentis.com/login") ,"Test Failed: User was able to access restricted page after logout by pressing back button !");
       System.out.println("Test passed : user cannot return to restricted page after logout");


   }
   @org.testng.annotations.Test(priority = 3)
    public void redirectedToHomePageTest(){
        logout.redirectedToHomePage();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://demowebshop.tricentis.com/"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        Assert.assertTrue(currentUrl.equals("https://demowebshop.tricentis.com/") ,"Test Failed: user did not redirected to home page after logout");
        System.out.println("The User successfully logged out to the Home page with url :" + currentUrl);

    }
    @AfterMethod
    public void Close_Driver(){
        driver.close();
    }
}
