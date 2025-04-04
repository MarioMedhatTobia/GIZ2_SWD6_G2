package filtering;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Filtering;
import java.util.List;
public class FilteringTest {
    final Filtering filtering = new Filtering();

    @Test
    public void verifyFilteringByPriceUnder1000Test() {
        filtering.applyPriceFilterUnder1000();
        // Get product prices after filtering
        List<Double> filteredPrices = filtering.getFilteredProductPrices();
        // Assertion: All products should be under $1000
        for (double price : filteredPrices) {
            Assert.assertTrue(price < 1000, "Product found with price >= 1000: " + price);
        }
    }
}
