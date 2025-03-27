package pages;

import Utilites.selenuim.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilites.selenuim.DriverFactory.driver;

public class Wishlist {


    public void PersistentWishlistValidation() throws InterruptedException {
        driver= DriverFactory.getDriver();

        driver.get("https://demowebshop.tricentis.com/");
driver.findElement(By.cssSelector(".ico-login")).click();
driver.findElement(By.cssSelector("#Email")).sendKeys("proftester27@gmail.com");
driver.findElement(By.cssSelector("#Password")).sendKeys("654321");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        TimeUnit.SECONDS.sleep(3);


        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']")).click();
driver.findElement(By.xpath("//div[@class='product-item']//img[@title=\"Show details for 50's Rockabilly Polka Dot Top JR Plus Size\"]")).click();
driver.findElement(By.cssSelector("#add-to-wishlist-button-5")).click();
driver.navigate().back();
driver.findElement(By.xpath("//div[@class='product-item']//img[@title='Show details for Blue and green Sneaker']")).click();
driver.findElement(By.cssSelector("#add-to-wishlist-button-28")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Digital downloads']")).click();
        driver.findElement(By.cssSelector("div[class='product-item'] img[title='Show details for 3rd Album']")).click();
        driver.findElement(By.cssSelector("#add-to-wishlist-button-53")).click();
        driver.navigate().back();
driver.findElement(By.cssSelector("div[class='page-body'] div:nth-child(2) div:nth-child(1) div:nth-child(1) a:nth-child(1) img:nth-child(1)")).click();
driver.findElement(By.cssSelector("#add-to-wishlist-button-51")).click();
        driver.findElement(By.cssSelector("div[class='header-links'] a[class='ico-wishlist']")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='page-title'] h1"))); // انتظار صريح
        List<WebElement> wishlistItems = driver.findElements(By.cssSelector("a[href='/50s-rockabilly-polka-dot-top-jr-plus-size'],a[href='/blue-and-green-sneaker'],a[href='/album-3'],a[href='/music-album-1']"));
        List<String> actualItemNames = new ArrayList<>();
        for (WebElement item : wishlistItems) {
            actualItemNames.add(item.getText());
        }

        List<String> expectedItemNames = List.of("50's Rockabilly Polka Dot Top JR Plus Size", "Blue and green Sneaker","3rd Album","Music 2");

        Assert.assertTrue(actualItemNames.containsAll(expectedItemNames));
        TimeUnit.SECONDS.sleep(3);



        driver.findElement(By.cssSelector(".ico-logout")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.cssSelector("#Email")).sendKeys("proftester27@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("654321");
        driver.findElement(By.cssSelector("input[value='Log in'], img[title='Show details for Blue and green Sneaker']")).click();
        TimeUnit.SECONDS.sleep(3);

        driver.findElement(By.cssSelector("div[class='header-links'] a[class='ico-wishlist']")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(3);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='page-title'] h1"))); // انتظار صريح لتحميل قائمة الأمنيات

        wishlistItems = driver.findElements(By.cssSelector("a[href='/50s-rockabilly-polka-dot-top-jr-plus-size'],a[href='/blue-and-green-sneaker'],a[href='/album-3'],a[href='/music-album-1']"));
        actualItemNames = new ArrayList<>();
        for (WebElement item : wishlistItems) {
            actualItemNames.add(item.getText());
        }

        expectedItemNames = List.of("50's Rockabilly Polka Dot Top JR Plus Size","Blue and green Sneaker","3rd Album","Music 2");

        Assert.assertTrue(actualItemNames.containsAll(expectedItemNames));




    }
    public void isWishlistEmpty() throws InterruptedException {
        driver.findElement(By.cssSelector(".ico-logout")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.cssSelector("#Email")).sendKeys("proftester28@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.cssSelector("div[class='header-links'] a[class='ico-wishlist']")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement AssertMassageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wishlist-content']")));
        String AssertMassage=AssertMassageElement.getText();
        Assert.assertEquals("The wishlist is empty!",AssertMassage);








    }
    public void moveItemToCart() throws InterruptedException {
        driver.findElement(By.cssSelector(".ico-logout")).click();
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.cssSelector("#Email")).sendKeys("proftester27@gmail.com");
        driver.findElement(By.cssSelector("#Password")).sendKeys("654321");
driver.findElement(By.cssSelector("input[value='Log in']")).click();
        TimeUnit.SECONDS.sleep(4);


        driver.findElement(By.cssSelector("div[class='header-links'] a[class='ico-wishlist']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).click();
        driver.findElement(By.xpath("//input[@name='addtocartbutton']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Shopping cart']"))); // انتظار صريح
        List<WebElement> wishlistItems = driver.findElements(By.cssSelector("a[href='/50s-rockabilly-polka-dot-top-jr-plus-size'],a[href='/blue-and-green-sneaker']"));
        List<String> actualItemNames = new ArrayList<>();
        for (WebElement item : wishlistItems) {
            actualItemNames.add(item.getText());
        }

        List<String> expectedItemNames = List.of("50's Rockabilly Polka Dot Top JR Plus Size", "Blue and green Sneaker");

        Assert.assertTrue(actualItemNames.containsAll(expectedItemNames));







    }


    public  void removeProduct() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);


        driver.findElement(By.cssSelector("div[class='header-links'] a[class='ico-wishlist']")).sendKeys(Keys.ENTER);
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]/input[1]")).click();
        TimeUnit.SECONDS.sleep(2);

        driver.findElement(By.cssSelector("input[value='Update wishlist']")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement AssertMassageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wishlist-content']")));
        String AssertMassage=AssertMassageElement.getText();
        Assert.assertEquals("The wishlist is empty!",AssertMassage);



    }
}
















