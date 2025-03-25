package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.seleinum.DriverFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static utilities.seleinum.DriverFactory.driver;

public class Filtering {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void applyPriceFilterUnder1000() {
        driver.findElement(By.xpath("//li[@class='inactive']//a[normalize-space()='Computers']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Desktops"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Under $1,000.00')]"))).click();
        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("product-item"))));
    }

    public List<Double> getFilteredProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-item .prices span"));
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }

}
