package Pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utilities.selenium.DriverFactory.driver;


public class Search {

    public void searchWithValidCredintials() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("Simple Computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));
        System.out.println(" Number of products found: " + products.size());

        for (WebElement product : products) {
            String productName = product.getText();
            System.out.println("Product: " + productName);

            Assert.assertTrue(productName.contains("Simple Computer"),
                    "Valid product found: " + productName);
        }
    }

    public void searchWithNonExist() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("/////");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        String expectedMessage = "No products were found that matched your criteria.";
        String actualMessage = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/strong")).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "\n" +
                "                    No products were found that matched your criteria.\n" +
                "                ");
    }

    public void searchWithOneWord() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        List<WebElement> products = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));
        System.out.println(" Number of products found: " + products.size());

        for (WebElement product : products) {
            String productName = product.getText();
            System.out.println("Product: " + productName);

            Assert.assertTrue(productName.toLowerCase().contains("computer"),
                    "Invalid product found: " + productName);
        }
    }
    public void searchCaseInsensitive() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        List<WebElement> lowerCaseResults = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));

        int lowerCaseCount = lowerCaseResults.size();
        List<String> lowerCaseProductNames = new ArrayList<>();
        for (WebElement product : lowerCaseResults) {
            lowerCaseProductNames.add(product.getText());
        }
        driver.findElement(By.id("small-searchterms")).sendKeys("COMPUTER");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        List<WebElement> upperCaseResults = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));
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

    public void SortAZAfterSearch() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("products-orderby")).sendKeys("Name: A to Z");
        List<WebElement> productElements = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));
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
    public void SortHighLowAfterSearch() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("products-orderby")).sendKeys("Price: High to Low");
        Thread.sleep(2000);
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

    public void searchDisplay4() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("products-pagesize")).sendKeys("4");
        Thread.sleep(2000);
        List<WebElement> productNo = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));

        Assert.assertEquals(productNo.size(), 4,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }
    public void searchDisplay8() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("products-pagesize")).sendKeys("8");
        List<WebElement> productNo = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));

        Assert.assertEquals(productNo.size(), 8,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }
    public void searchDisplay12() throws InterruptedException {
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.id("small-searchterms")).sendKeys("computer");
        driver.findElement(By.xpath("//input[@class='button-1 search-box-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("products-pagesize")).sendKeys("12");
        List<WebElement> productNo = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[3]/div[1]/div[1]"));

        Assert.assertEquals(productNo.size(), 12,
                "Mismatch in product count for case-sensitive search!");
        System.out.println("Case-insensitive search test passed!");
    }
}




