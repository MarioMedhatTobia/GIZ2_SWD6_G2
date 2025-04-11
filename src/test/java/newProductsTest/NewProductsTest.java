package newProductsTest;

import Page.NewProducts;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import jdk.jfr.Description;
import org.testng.annotations.AfterTest;

import static Utilities.selenium.DriverFactory.driver;


public class NewProductsTest {
    final NewProducts newProducts = new NewProducts();
    @org.testng.annotations.Test(priority = 1)
    @Description("Testing automation")
    @Link("https://talent500.com/blog/how-to-install-and-use-the-scoop-windows-package-manager/")
    @Tag("End to End")
    @Severity(SeverityLevel.CRITICAL)

    public void ClickOnNewProducts(){
        newProducts.ClickNewProducts();
    }
//    @AfterTest
//    public void Close_Driver(){
//        driver.close();
//    }


}
