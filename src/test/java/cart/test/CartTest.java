package cart.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.Home;
import pages.ProductDetails;
import pages.ShoppingCart;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class CartTest {
    final Home home = new Home();
    final ShoppingCart shoppingCart = new ShoppingCart();
    final ProductDetails productDetails = new ProductDetails();

    @org.testng.annotations.Test(priority = 1)
    public void testAddProductToCart() {
        home.addProductToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageAddElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        String successMessageAdd = successMessageAddElement.getText();
        Assert.assertEquals(successMessageAdd, "The product has been added to your shopping cart");
    }
    @org.testng.annotations.Test(priority = 2)
    public void testChangeProductQuantityValid(){
        shoppingCart.changeProductQuantityValid();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement correctSubTotalText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='product-subtotal']")));
        String correctSubTotal = correctSubTotalText.getText();
        Assert.assertEquals(correctSubTotal, "31800.00");
    }
    @org.testng.annotations.Test(priority = 3)
    public void testRemoveProductFromCart(){
        shoppingCart.removeProductFromCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageRemoveText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-summary-content']")));
        String successMessageRemove = successMessageRemoveText.getText();
        Assert.assertEquals(successMessageRemove, "Your Shopping Cart is empty!");
    }
    @org.testng.annotations.Test(priority = 4)
    public void testChangeProductQuantityInvalid(){
        productDetails.changeProductQuantityInvalid();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageAddText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        String errorMessageAdd = errorMessageAddText.getText();
        Assert.assertEquals(errorMessageAdd, "Quantity should be positive");

    }
    @org.testng.annotations.Test(priority = 5)
    public void testChangeProductQuantityToZeroInCart(){
        productDetails.changeProductQuantityToZeroInCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessageRemoveText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='order-summary-content']")));
        String successMessageRemove = successMessageRemoveText.getText();
        Assert.assertEquals(successMessageRemove, "Your Shopping Cart is empty!");
    }
}
