package Page;

import Utilities.selenium.DriverFactory;
import Utilities.testData.Constant;
import org.openqa.selenium.By;
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

}
