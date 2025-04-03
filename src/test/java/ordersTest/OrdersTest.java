package ordersTest;

import Page.Checkout;
import Page.Login;
import Page.Orders;

import Page.ShoppingCart;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Utilities.selenium.DriverFactory.driver;


public class OrdersTest {


    final Login login = new Login();
    final ShoppingCart shoppingCart = new ShoppingCart();
    final Checkout checkout = new Checkout();

    @org.testng.annotations.Test(priority = 1)
    @Description("Testing automation")

    @Link("https://talent500.com/blog/how-to-install-and-use-the-scoop-windows-package-manager/")
    @Tag("End to End")
    @Severity(SeverityLevel.CRITICAL)


    public void LoginSuccess(){
        login.loginWithValidCredentials();
    }
    @org.testng.annotations.Test(priority = 2)
    public void EnterValidBuyer() {
        shoppingCart.ValidBuyer();
    }

    @org.testng.annotations.Test(priority = 3)
    public void CheckoutSuccessTest(){
        checkout.ValidCheckout();
    }



    final Orders orders = new Orders();
    @org.testng.annotations.Test(priority = 1)
    @Description("Testing automation")
    @Link("https://talent500.com/blog/how-to-install-and-use-the-scoop-windows-package-manager/")
    @Tag("End to End")
    @Severity(SeverityLevel.CRITICAL)

    public void EnterValidOrder() {
        orders.ValidOrder();
    }
}