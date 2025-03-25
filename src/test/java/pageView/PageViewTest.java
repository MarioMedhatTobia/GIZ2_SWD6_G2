package pageView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageView;

import static utilities.seleinum.DriverFactory.driver;

public class PageViewTest {
    final PageView pageview = new PageView();
    @org.testng.annotations.Test(priority=1)
    public void changeViewToListTest() {
        // Change the view to "List" within the "Apparel and Shoes" category
        pageview.changeViewToList();
        // Optional: Add assertions to confirm that the view has been updated to "List"
        WebElement listViewElement = driver.findElement(By.cssSelector(".product-list")); // Adjust the selector based on your HTML structure
        Assert.assertTrue(listViewElement.isDisplayed(), "List view is not displayed.");
}}
