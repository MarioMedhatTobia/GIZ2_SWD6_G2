package TestCases;

import Pages.CompareProducts;
import Utilities.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareProductsTest {
    private WebDriver driver;
    private CompareProducts compareProducts;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        compareProducts = new CompareProducts();
    }

    @Test
    public void testRemoveProductFromCompareList() {
        // Add two products to the compare list
        compareProducts.openHomePage();
        compareProducts.goToBooksCategory();
        compareProducts.addBookToCart();
        compareProducts.addToCompareList();

        compareProducts.goToFictionCategory();
        compareProducts.addToCompareList();

        // Open compare page and remove a product
        compareProducts.openComparePage();
        compareProducts.removeFromCompareList();

        // Validate that the compare list is updated
        Assert.assertTrue(compareProducts.isCompareListDisplayed(), "Compare list is not updated after removal!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
