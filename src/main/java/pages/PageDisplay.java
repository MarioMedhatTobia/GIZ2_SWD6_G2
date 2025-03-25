package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static utilities.seleinum.DriverFactory.driver;
public class PageDisplay {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void changeProductsPerPage(int count) {
        // Step 1: Navigate to the "Apparel and Shoes" category directly
         driver.findElement(By.xpath("//li[@class='active']//a[normalize-space()='Apparel & Shoes']")).click();

        // Step 2: Locate the dropdown for products per page
        WebElement dropdown = driver.findElement(By.id("products-pagesize"));

        // Use the Select class to choose the desired option
        Select select = new Select(dropdown);
        select.selectByValue(String.valueOf(count)); // Select the value matching the count

        // Wait until the dropdown reflects the correct selection
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeToBe(dropdown, "value", String.valueOf(count)));
}
// Count the number of displayed products on the page
    public int getDisplayedProductCount() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        return products.size();
}}







