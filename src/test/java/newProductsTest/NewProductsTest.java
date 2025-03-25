package newProductsTest;

import Page.NewProducts;
import Utilities.selenium.DriverFactory;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewProductsTest {
    final NewProducts newProducts = new NewProducts();

    @BeforeSuite

    public void set_up() {
        driver = DriverFactory.getDriver();
    }


    @Description("Testing automation")
    @Link("https://talent500.com/blog/how-to-install-and-use-the-scoop-windows-package-manager/")
    @Tag("End to End")
    @Severity(SeverityLevel.CRITICAL)
 @org.testng.annotations.Test(priority = 1)
    public void ClickOnNewProducts(){
        newProducts.ClickNewProducts();
       String currentUrl = driver.getCurrentUrl();
       System.out.println("current url : " +currentUrl );
       Assert.assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/cart"));
       WebElement currentProduct = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]"));
       String currentProductText =currentProduct.getText();
       Assert.assertEquals("TBlue Jeans", currentProductText);
        System.out.println("current product : " +currentProductText );





    }


    @org.testng.annotations.Test(priority = 2)
    public void ClickOnNewProducts2() {
        newProducts.ClickNewProducts2();
        String currentUrl2 = driver.getCurrentUrl();
        System.out.println("current url : " +currentUrl2 );
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/cart"));
      //  WebElement currentProduct = driver.findElement(By.xpath("")





    }
}







  //  @AfterTest
   // public void Close_Driver(){
       // driver.close();

   // }
//}

//    @AfterTest
//    public void Close_Driver(){
//        driver.close();
//    }



