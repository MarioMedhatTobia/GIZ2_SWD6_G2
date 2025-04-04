package sorting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Sorting;
import static utilities.seleinum.DriverFactory.driver;
public class SortingTest {
    final Sorting sorting = new Sorting();
    @org.testng.annotations.Test(priority=1)
    public void verifySortingByPriceLowToHighTest(){
    sorting.verifySortingByPriceLowToHigh();
        WebElement FirstProductPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        WebElement LastProductPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        String firstProductPriceText = FirstProductPrice.getText().replace("$", "").trim(); // Remove currency symbol if any
        WebElement lastProductPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        String lastProductPriceText = lastProductPriceElement.getText().replace("$", "").trim(); // Remove currency symbol if any
        Double firstProductPrice = Double.parseDouble(firstProductPriceText);
        Double lastProductPrice = Double.parseDouble(lastProductPriceText);
        Assert.assertTrue(firstProductPrice < lastProductPrice, "Sorting Failed: First product price is not less than the last product price.");
}
    @org.testng.annotations.Test(priority=2)
    public void verifySortingByPriceHighToLowTest() {
        sorting.verifySortingByPriceHighToLow();
        WebElement firstProductPrice = driver.findElement(By.xpath("//span[normalize-space()='40.00']"));
        WebElement lastProductPrice = driver.findElement(By.xpath("//div[5]//div[1]//div[2]//div[3]//div[1]//span[1]"));
        double firstPrice = Double.parseDouble(firstProductPrice.getText().replace("$", "").trim());
        double lastPrice = Double.parseDouble(lastProductPrice.getText().replace("$", "").trim());
        Assert.assertTrue(firstPrice >= lastPrice, "Prices are not sorted from high to low");
    }
    @org.testng.annotations.Test(priority=3)
    public void verifySortingByNameAToZTest() {
        sorting.verifySortingByNameAtoZ();
        WebElement firstProductName = driver.findElement(By.xpath("//a[normalize-space()='Black & White Diamond Heart']"));
        WebElement lastProductName = driver.findElement(By.xpath("//a[normalize-space()='Vintage Style Three Stone Diamond Engagement Ring']"));
        String firstName = firstProductName.getText().trim();
        String lastName = lastProductName.getText().trim();
        Assert.assertTrue(firstName.compareTo(lastName) <= 0, "Names are not sorted alphabetically");
    }}
