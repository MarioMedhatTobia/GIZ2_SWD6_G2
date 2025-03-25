package filtering;
import org.testng.Assert;
import pages.Filtering;
import utilities.seleinum.DriverFactory;

import java.util.List;

import static utilities.seleinum.DriverFactory.driver;

public class FilteringTest {
    final Filtering filtering = new Filtering();

    @org.testng.annotations.Test(priority=1)
    public void verifyFilteringByPriceUnder1000Test() {
        driver = DriverFactory.getDriver();
        filtering.applyPriceFilterUnder1000();
        // Get product prices after filtering
        List<Double> filteredPrices = filtering.getFilteredProductPrices();
        // Assertion: All products should be under $1000
        for (double price : filteredPrices) {
            Assert.assertTrue(price < 1000, "Product found with price >= 1000: " + price);
        }
    }
}
