package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Search {
  WebDriver driver = new ChromeDriver();

    public void searchWithValidCredintials() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("Simple Computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        List<WebElement> products = driver.findElements(By.cssSelector(".product-title a"));
        System.out.println(" Number of products found: " + products.size());

        for (WebElement product : products) {
            String productName = product.getText();
            System.out.println("Product: " + productName);

            Assert.assertTrue(productName.contains("Simple Computer"),
                    "Invalid product found: " + productName);
        }
    }

    public void searchWithNonExist() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("/////");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        String expectedMessage = "No products were found that matched your criteria.";
        String actualMessage = driver.findElement(By.xpath("//strong[@class='result']")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Search result message does not match!");
    }

    public void searchWithOneWord() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

        List<WebElement> products = driver.findElements(By.cssSelector(".product-title a"));
        System.out.println(" Number of products found: " + products.size());

        for (WebElement product : products) {
            String productName = product.getText();
            System.out.println("Product: " + productName);

            Assert.assertTrue(productName.toLowerCase().contains("computer"),
                    "Invalid product found: " + productName);
        }
    }
    public void searchCaseInsensitive() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        List<WebElement> lowerCaseResults = driver.findElements(By.cssSelector(".product-title a"));

        int lowerCaseCount = lowerCaseResults.size();
        List<String> lowerCaseProductNames = new ArrayList<>();
        for (WebElement product : lowerCaseResults) {
            lowerCaseProductNames.add(product.getText());
        }
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("COMPUTER");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();

        List<WebElement> upperCaseResults = driver.findElements(By.cssSelector(".product-title a"));
        int upperCaseCount = upperCaseResults.size();
        List<String> upperCaseProductNames = new ArrayList<>();
        for (WebElement product : upperCaseResults) {
            upperCaseProductNames.add(product.getText());
        }

        Assert.assertEquals(lowerCaseCount, upperCaseCount,
                "Mismatch in product count for case-sensitive search!");
        Assert.assertEquals(lowerCaseProductNames, upperCaseProductNames,
                "Mismatch in product names for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }

    public void SortAZAfterSearch() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Name: A to Z");
        List<WebElement> productElements = driver.findElements(By.cssSelector(".product-title a"));
        List<String> actualProductNames = new ArrayList<>();
        for (WebElement product : productElements) {
            actualProductNames.add(product.getText());
        }
        List<String> expectedProductNames = new ArrayList<>(actualProductNames);
        expectedProductNames.sort(String::compareToIgnoreCase);

        Assert.assertEquals(actualProductNames, expectedProductNames,
                "Products are not sorted from A-Z!");

        System.out.println(" Sorting from A-Z test passed!");
    }
    public void SortHighLowAfterSearch() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        driver.findElement(By.id("products-orderby")).sendKeys("Price: High to Low");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".actual-price")));

        List<WebElement> priceElements = driver.findElements(By.cssSelector(".actual-price"));

        List<Double> actualPrices = new ArrayList<>();
        System.out.println("Actual Product Prices (Before Sorting):");
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText();
            if (!priceText.isEmpty()) {
                Double price = Double.parseDouble(priceText);
                actualPrices.add(price);
                System.out.println( price); // Print price in console
            }
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder()); // Sort from High to Low

        System.out.println("\n Expected Sorted Prices (High to Low):");
        for (Double price : expectedPrices) {
            System.out.println( + price);
        }

        Assert.assertEquals(actualPrices, expectedPrices, "Products are NOT sorted from High to Low!");

        System.out.println("Sorting from High - Low test passed!");
    }

    public void searchDisplay4() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        driver.findElement(By.id("products-pagesize")).sendKeys("4");
        List<WebElement> productNo = driver.findElements(By.cssSelector(".product-title a"));

        Assert.assertEquals(productNo.size(), 4,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }
    public void searchDisplay8() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        driver.findElement(By.id("products-pagesize")).sendKeys("8");
        List<WebElement> productNo = driver.findElements(By.cssSelector(".product-title a"));

        Assert.assertEquals(productNo.size(), 8,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }
    public void searchDisplay12() {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        driver.findElement(By.id("products-pagesize")).sendKeys("12");
        List<WebElement> productNo = driver.findElements(By.cssSelector(".product-title a"));

        Assert.assertEquals(productNo.size(), 12,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }

}




