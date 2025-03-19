package Pages;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utilities.selenium.DriverFactory.driver;

public class Login {


    public void loginWithValidCredentials() {
        //driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        driver.findElement(By.id("Email")).sendKeys(Constant.loginValidEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.loginValidPassword);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();


    }

    public void loginWithInvalidCredentials() {

        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.id("Email")).sendKeys(Constant.loginInvalidEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.loginInvalidPassword);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();

    }

    public void verifyLoginCaseSensitive() {
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.id("Email")).sendKeys(Constant.loginCaseSensitiveEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.loginCaseSensitivePassword);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();


    }
    public void verifyForgetPassword() {
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.id("Email")).sendKeys(Constant.loginValidEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.loginInvalidPassword);
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[4]/span[1]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys(Constant.loginValidEmail);
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]")).click();
    }






}






