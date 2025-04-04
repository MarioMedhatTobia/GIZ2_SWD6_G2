package pageDisplay;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageDisplay;
public class PageDisplayTest {
    final PageDisplay pageDisplay = new PageDisplay();
    @Test
    public void changeProductsPerPageTest() {

        // Step 2: Change the product display to 12 per page
        pageDisplay.changeProductsPerPage();

        // Step 3: Get the number of displayed products
        int displayedProductCount = pageDisplay.getDisplayedProductCount();

        // Step 4: Assert that 12 products are displayed
        Assert.assertEquals(displayedProductCount, 12, "Expected 12 products to be displayed on the page.");
    }
}
