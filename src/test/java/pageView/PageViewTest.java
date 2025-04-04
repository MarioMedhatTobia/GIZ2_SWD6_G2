package pageView;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageView;

import static utilities.seleinum.DriverFactory.driver;

public class PageViewTest {
    final PageView pageview = new PageView();
    @Test
    public void changeViewToListTest() {
        // Change the view to "List" within the "Apparel and Shoes" category
        pageview.changeViewToList();
        // Optional: Add assertions to confirm that the view has been updated to "List"
        WebElement listViewElement = driver.findElement(By.cssSelector("#products-viewmode")); // Adjust the selector based on your HTML structure
        Assert.assertTrue(listViewElement.isDisplayed(), "List view is not displayed.");
}}
