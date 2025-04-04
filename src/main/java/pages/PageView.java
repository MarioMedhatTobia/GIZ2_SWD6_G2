package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static utilities.seleinum.DriverFactory.driver;
public class PageView {
    public void changeViewToList() {
        driver.findElement(By.id("products-viewmode")).sendKeys("List");

    }
}
