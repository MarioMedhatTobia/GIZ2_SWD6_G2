package pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;

import static Utilities.selenium.DriverFactory.driver;

public class Home {
    public void addFeaturedProductToCart(){
        driver = DriverFactory.getDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']//div[3]//div[1]//div[2]//div[3]//div[2]//input[1]")).click();
    }
}
