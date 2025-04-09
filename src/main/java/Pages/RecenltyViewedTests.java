package Pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class RecenltyViewedTests  {
    public WebDriver driver;

    public int[] Viewed_Array = new int[4];

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com");
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test(priority = 1)
    public void ProductsDisplayedTest()
    {
       driver.manage().deleteAllCookies();// delete all cache so empty recently viewed
       driver.findElement(By.linkText("Apparel & Shoes")).click();
        try {
            Thread.sleep(2000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        viewProduct(5);
        driver.navigate().back();
        viewProduct(28);
        driver.navigate().back();
        viewProduct(36);
        driver.navigate().back();
        viewProduct(40);
        driver.navigate().back();

        CheckViewedProductID();

    }


    @Test(priority = 2)
    public void AddToCartTest()
    {
        int Items=0;
        // first  products viewed is needed (using test1 already)
        // then   try to click on add to cart
        driver.findElement(By.linkText("Recently viewed products")).click();
        try {
            Thread.sleep(1000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Press on each product
        for (int Id: Viewed_Array)
        {
            if (Id == 0) continue;
            driver.findElement(By.cssSelector(".product-item[data-productid='" + Id + "'] .product-title a")).click();
            try {
                Thread.sleep(1000); // Wait for 3 seconds
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.findElement(By.cssSelector(".button-1.add-to-cart-button")).click();
            Items++;
            driver.navigate().back();
            driver.navigate().refresh();
        }


        // assert on the number of the shopping cart
        int cartQuantity = Integer.parseInt(driver.findElement(By.cssSelector(".ico-cart .cart-qty")).getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(Items,cartQuantity,"Test Failed: Qty Cart quantity mismatch");
    }

    @Test(priority = 3)
    public void ClearCasheTest ()
    { // Supposed that if the cache is deleted there will be no recently viewed items
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Arrays.fill(Viewed_Array, 0); // reset the viewed array
        driver.findElement(By.linkText("Recently viewed products")).click();
        try {
            Thread.sleep(2000); // Wait for 2 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // extract all products IDs
        List<WebElement> Displayed_Products = driver.findElements(By.cssSelector(".product-item"));
        Assert.assertTrue(Displayed_Products.isEmpty(),"Test Failed : Recently viewed products list is NOT empty!");
    }

    public void viewProduct(int productId)
    {
        driver.findElement(By.cssSelector(".product-item[data-productid='" + productId + "'] .product-title a")).click();
        try {
            Thread.sleep(1000); // Wait for 1 second
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(Viewed_Array,1,Viewed_Array,0,3);// shift array to the left FIFO
        Viewed_Array[3]=productId;// save in array last element

    }
    public void CheckViewedProductID()
    {
        //method to extract product from recently viewed page
        // must be in recently viewed page
        driver.findElement(By.linkText("Recently viewed products")).click();
        try {
            Thread.sleep(2000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // extract all products IDs
        List<WebElement> Displayed_Products = driver.findElements(By.cssSelector(".product-item"));// class name
        boolean AllProductsFound= true;
        for (WebElement product: Displayed_Products)
        {
            int CurrentId = Integer.parseInt(Objects.requireNonNull(product.getAttribute("data-productid")));// extract current product id
            boolean ProductFound= false;
            for (int Id: Viewed_Array)
            {
                if (Id == 0) continue; // less than 4 items
                if (CurrentId == Id) {
                    ProductFound = true;
                    break;
                }
            }

            if (!ProductFound)
            {
                AllProductsFound=false;
            }

            Assert.assertTrue(AllProductsFound, "Test Failed: Some expected products are missing from Recently Viewed Products.");

        }
    }
}
