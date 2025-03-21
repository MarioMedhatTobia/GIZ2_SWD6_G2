package Pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CompareProducts {
    private WebDriver driver;
    private WebDriverWait wait;

    public CompareProducts() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Max wait time 10 seconds
    }

    public void openHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/books']")));
    }

    public void goToBooksCategory() {
        driver.findElement(By.xpath("//a[@href='/books']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'computing-and-internet')]")));
    }

    public void addBookToCart() {
        driver.findElement(By.xpath("//a[contains(@href, 'computing-and-internet')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add to cart']"))).click();
    }

    public void addToCompareList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add to compare list']"))).click();
    }

    public void goToFictionCategory() {
        driver.get("https://demowebshop.tricentis.com/fiction");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Add to compare list']")));
    }

    public void openComparePage() {
        driver.get("https://demowebshop.tricentis.com/compareproducts");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compare-products-table")));
    }

    public boolean isCompareListDisplayed() {
        return driver.findElement(By.className("compare-products-table")).isDisplayed();
    }

    public void removeFromCompareList() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Remove']"))).click();
    }
}
