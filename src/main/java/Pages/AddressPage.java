package Pages;

import Utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddressPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddressPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
        driver.get("https://demowebshop.tricentis.com/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
    }

    public void login(String email, String password) {
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Log in']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/customer/addresses']")));
    }

    public void goToAddressesPage() {
        driver.findElement(By.cssSelector("a[href='/customer/addresses']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value='Add new']")));
    }

    public void clickAddNewAddress() {
        driver.findElement(By.cssSelector("input[value='Add new']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Address_FirstName")));
    }

    public void fillAddressForm(String firstName, String lastName, String email,
                                String company, String country, String city,
                                String address1, String address2, String zipCode,
                                String phoneNumber, String faxNumber) {
        driver.findElement(By.id("Address_FirstName")).sendKeys(firstName);
        driver.findElement(By.id("Address_LastName")).sendKeys(lastName);
        driver.findElement(By.id("Address_Email")).sendKeys(email);
        driver.findElement(By.id("Address_Company")).sendKeys(company);

        Select countrySelect = new Select(driver.findElement(By.id("Address_CountryId")));
        countrySelect.selectByVisibleText(country);

        driver.findElement(By.id("Address_City")).sendKeys(city);
        driver.findElement(By.id("Address_Address1")).sendKeys(address1);
        driver.findElement(By.id("Address_Address2")).sendKeys(address2);
        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(zipCode);
        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phoneNumber);
        driver.findElement(By.id("Address_FaxNumber")).sendKeys(faxNumber);
    }

    public void saveAddress() {
        driver.findElement(By.cssSelector("input[value='Save']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".add-address-button")));
    }

    public boolean isAddressSaved() {
        return driver.findElements(By.cssSelector(".address-list")).size() > 0;
    }

    public void editFirstAddress() {
        driver.findElement(By.cssSelector("input[value='Edit']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Address_FirstName")));
    }

    public void updateAddressCity(String newCity) {
        WebElement cityField = driver.findElement(By.id("Address_City"));
        cityField.clear();
        cityField.sendKeys(newCity);
    }

    public void deleteFirstAddress() {
        driver.findElement(By.cssSelector("input[value='Delete']")).click();
        driver.switchTo().alert().accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".address-list")));
    }

    public boolean isAddressDeleted() {
        return driver.findElements(By.cssSelector(".address-list")).size() == 0;
    }
}