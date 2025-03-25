package sorting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utilities.seleinum.DriverFactory.driver;

public class SortingTest {
    final Sorting sorting = new Sorting();

    @org.testng.annotations.Test(priority=1)
    public void verifySortingByPriceLowToHighTest(){
    sorting.verifySortingByPriceLowToHigh();
        WebElement FirstProductPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        WebElement LastProductPrice = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        String firstProductPriceText = FirstProductPrice.getText().replace("$", "").trim(); // Remove currency symbol if any
        // Locate the last product's price and extract its text
        WebElement lastProductPriceElement = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[6]/div[1]/div[2]/div[3]/div[1]/span[2]"));
        String lastProductPriceText = lastProductPriceElement.getText().replace("$", "").trim(); // Remove currency symbol if any
        // Convert the extracted text into integers for comparison
        Double firstProductPrice = Double.parseDouble(firstProductPriceText);
        Double lastProductPrice = Double.parseDouble(lastProductPriceText);
        Assert.assertTrue(firstProductPrice < lastProductPrice, "Sorting Failed: First product price is not less than the last product price.");

}}
