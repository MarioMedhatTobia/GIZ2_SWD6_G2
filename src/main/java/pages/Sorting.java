package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.seleinum.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import static utilities.seleinum.DriverFactory.driver;
public class Sorting {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void verifySortingByPriceLowToHigh(){
   driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com/");
//        driver.findElement(By.xpath("//li[@class='active']//a[normalize-space()='Books']")).click();
//        WebElement sortingDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-orderby")));
//        Select select = new Select(sortingDropdown);
//        select.selectByVisibleText("Price: Low to High");
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("product-item"))));}
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Books']")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Position");
        driver.findElement(By.id("products-orderby")).sendKeys("Price: Low to High");


    // Method to get product prices
//        public List<Double> getProductPrices() {
//            List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-item .prices span"));
//            return priceElements.stream()
//                    .map(e -> Double.parseDouble(e.getText().replace("$", "").trim()))
//                    .collect(Collectors.toList());
        }
    public void verifySortingByPriceHighToLow() {
        driver.findElement(By.xpath("//li[@class='inactive']/a[normalize-space()='Apparel & Shoes']")).click();
        WebElement sortingDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-orderby")));
        Select select = new Select(sortingDropdown);
        select.selectByVisibleText("Price: High to Low");
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("product-item"))));
    }
    public void verifySortingByNameAtoZ() {
        driver.findElement(By.xpath("//li[@class='inactive']/a[normalize-space()='Jewelry']")).click();
        WebElement sortingDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("products-orderby")));
        Select select = new Select(sortingDropdown);
        select.selectByVisibleText("Name: A to Z");
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("product-item"))));
    }
    // Method to get product names
    public List<String> getProductNames() {
        List<WebElement> productElements = driver.findElements(By.cssSelector(".product-item h2 a"));
        return productElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
