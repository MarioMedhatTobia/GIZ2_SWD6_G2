package Pages;



import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static Utilities.selenium.DriverFactory.driver;

public class Registration {


    public void registrationWithAllBlankFields() throws InterruptedException {
        //driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("");
        driver.findElement(By.id("LastName")).sendKeys("");
        driver.findElement(By.id("Email")).sendKeys("");
        driver.findElement(By.id("Password")).sendKeys("");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("");
        driver.findElement(By.id("register-button")).click();

    }


    public void registrationWithValidCredentials(){
        //driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(Constant.RegisterValidFirstName);
        driver.findElement(By.id("LastName")).sendKeys(Constant.RegisterValidLastName);
        driver.findElement(By.id("Email")).sendKeys(Constant.randomEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.RegisterValidPassword);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Constant.RegisterValidPassword);
        driver.findElement(By.id("register-button")).click();
        //driver.findElement(By.cssSelector("input[value='Continue']")).click();
    }
    public void registrationWithRegisteredEmail(){

        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(Constant.RegisterValidFirstName);
        driver.findElement(By.id("LastName")).sendKeys(Constant.RegisterValidLastName);
        driver.findElement(By.id("Email")).sendKeys(Constant.RegisterValidEmail);
        driver.findElement(By.id("Password")).sendKeys(Constant.RegisterValidPassword);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Constant.RegisterValidPassword);
        driver.findElement(By.id("register-button")).click();
        //driver.findElement(By.cssSelector("input[value='Continue']")).click();
    }


}



