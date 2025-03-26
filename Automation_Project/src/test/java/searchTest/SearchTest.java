package searchTest;

import Pages.Search;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import static Utilities.selenium.DriverFactory.driver;

public class SearchTest {
    final Search search = new Search();

    @org.testng.annotations.Test(priority = 1)
    public void searchHappyScenario() throws InterruptedException {
        search.searchWithValidCredintials();
    }

    @org.testng.annotations.Test(priority = 2)
    public void searchNonExist() throws InterruptedException {
        search.searchWithNonExist();
    }

    @org.testng.annotations.Test(priority = 3)
    public void searchWithGeneralWord() throws InterruptedException {
        search.searchWithOneWord();
    }

    @org.testng.annotations.Test(priority = 4)
    public void searchCaseSensitive() throws InterruptedException {
        search.searchCaseInsensitive();
    }

    @org.testng.annotations.Test(priority = 5)
    public void searchAscendingAlphabetically() throws InterruptedException {
        search.SortAZAfterSearch();
    }

    @org.testng.annotations.Test(priority = 6)
    public void searchDesendingPrices() throws InterruptedException {
        search.SortHighLowAfterSearch();
    }

    @org.testng.annotations.Test(priority = 7)
    public void searchView4() throws InterruptedException {
        search.searchDisplay4();
    }

    @org.testng.annotations.Test(priority = 8)
    public void searchView8() throws InterruptedException {
        search.searchDisplay8();
    }

    @org.testng.annotations.Test(priority = 9)
    public void searchView12() throws InterruptedException {
        search.searchDisplay12();
    }
    @AfterTest
    public void Close_Driver(){
        driver.close();
    }
}
