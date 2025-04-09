package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utilities.seleinum.DriverFactory.driver;
public class Sorting {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void verifySortingByPriceLowToHigh(){
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Position");
        driver.findElement(By.id("products-orderby")).sendKeys("Price: Low to High");
    }
    public void verifySortingByPriceHighToLow() {
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active']/a[normalize-space()='Apparel & Shoes']")));
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Position");
        driver.findElement(By.id("products-orderby")).sendKeys("Price: High to Low");
    }
    public void verifySortingByNameAtoZ() {
       // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active']/a[normalize-space()='Jewelry']")));
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[6]/a[1]")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Position");
        driver.findElement(By.id("products-orderby")).sendKeys("Name: A to Z");
    }
}
