package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.seleinum.DriverFactory;
import static utilities.seleinum.DriverFactory.driver;
import java.time.Duration;
public class Categories {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void verifyCategoryNavigation () {
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Books']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Computers']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Notebooks']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Accessories']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Electronics']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Camera, photo']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Cell phones']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Digital downloads']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Jewelry']")).click();
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Gift Cards']")).click();
    }
    public void verifyCategoryPageUIElements(){
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Books']")).click();
        driver.findElement(By.className("current-item")).isDisplayed();
        driver.findElement(By.id("products-orderby")).isDisplayed();
        driver.findElement(By.id("products-pagesize")).isDisplayed();
        driver.findElement(By.id("products-viewmode")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='page category-page']//li[1]//a[1]")).isDisplayed();
    }
    //public void verifyBreadcrumbNavigation(){}
    }




