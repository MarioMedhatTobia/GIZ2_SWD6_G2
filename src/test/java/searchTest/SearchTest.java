package searchTest;


import Page.Search;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import java.time.Duration;

import static Utilities.selenium.DriverFactory.driver;


public class SearchTest {

    final Search search = new Search();
    @org.testng.annotations.Test(priority = 1)
    @Description("Testing automation")
    @Link("https://talent500.com/blog/how-to-install-and-use-the-scoop-windows-package-manager/")
    @Tag("End to End")
    @Severity(SeverityLevel.CRITICAL)

    public void EnterValidSearch(){
        search.ValidSearch();
    }
    @AfterTest
    public void Close_Driver(){
        driver.close();
    }
}
