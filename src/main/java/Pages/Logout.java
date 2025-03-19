package Pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;

public class Logout {

    public void successLogout() {

        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();

    }

    public void accessRestrictedPages() throws InterruptedException {
        //driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[7]/a[1]")).click();
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
        driver.navigate().back();


    }

    public void redirectedToHomePage() {
        driver.findElement(By.xpath("//a[@class='ico-logout']")).click();

    }

    public void addToCart() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/img[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        // driver.findElement(By.cssSelector(".product-box-add-to-cart-button")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[2]"), "(0)")));

        System.out.println(" Product added to cart successfully!");

        }
    public String getCartQuantity(){

        return driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[2]")).getText();
    }

}


