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
        // Step 1: Navigate to the "Apparel and Shoes" category
       driver.findElement(By.xpath("//li[@class='active']//a[normalize-space()='Apparel & Shoes']")).click();

        // Wait until the category page loads completely
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains("Apparel and Shoes"));

        // Step 2: Locate the dropdown for changing the view
        WebElement viewDropdown = driver.findElement(By.id("products-viewmode"));

        // Use the Select class to change the view to "List"
        Select select = new Select(viewDropdown);
        select.selectByVisibleText("List");

        // Optional: Wait for the change to take effect (e.g., a specific element in List view to load)
        //new WebDriverWait(driver, Duration.ofSeconds(10))
        //        .until(ExpectedConditions.attributeToBe(viewDropdown, "value", "List"));
    }
}
