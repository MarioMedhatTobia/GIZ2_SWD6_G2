package cart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Home;
import pages.ShoppingCart;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class CartTest {
    final Home home = new Home();
    final ShoppingCart shoppingCart = new ShoppingCart();

    @org.testng.annotations.Test(priority = 1)
    public void addToCart() {
        home.addFeaturedProductToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageAddElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        String successMessageAdd = successMessageAddElement.getText();
        Assert.assertEquals(successMessageAdd, "The product has been added to your shopping cart");
    }
    @org.testng.annotations.Test(priority = 2)
    public void removeFromCart(){
        shoppingCart.removeFeaturedProductFromCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageRemoveElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-summary-content']")));
        String successMessageRemove = successMessageRemoveElement.getText();
        Assert.assertEquals(successMessageRemove, "Your Shopping Cart is empty!");
    }
}
