package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import static utilities.seleinum.DriverFactory.driver;
public class Filtering {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void applyPriceFilterUnder1000() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
       // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")));
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[1]/a[1]")).click();
        driver.findElement(By.className("product-item"));
    }
    public List<Double> getFilteredProductPrices() {
        List<WebElement> priceElements = driver.findElements(By.cssSelector(".product-item .prices span"));
        return priceElements.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }
}
