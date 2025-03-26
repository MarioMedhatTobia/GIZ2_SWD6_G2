package TestCases;

import Pages.AddressPage;
import Utilities.selenium.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressTest {
    private WebDriver driver;
    private AddressPage addressPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        addressPage = new AddressPage();
    }

    @Test(priority = 1)
    public void testAddNewAddress() {
        addressPage.openLoginPage();
        addressPage.login("proftester25@gmail.com", "Tester@123");
        addressPage.goToAddressesPage();
        addressPage.clickAddNewAddress();

        addressPage.fillAddressForm(
                "Adam",
                "Osama",
                "adamosama9080@outlook.com",
                "IBA",
                "Egypt",
                "Dokki",
                "14 Abdalhmeed olotfi dokki",
                "11th district 6th october city",
                "15555",
                "01112675750",
                "0238242854"
        );

        addressPage.saveAddress();
        Assert.assertTrue(addressPage.isAddressSaved(), "Address was not saved successfully");
    }

    @Test(priority = 2)
    public void testEditAddress() {
        addressPage.editFirstAddress();
        addressPage.updateAddressCity("Giza");
        addressPage.saveAddress();
        Assert.assertTrue(addressPage.isAddressSaved(), "Address was not updated successfully");
    }

    @Test(priority = 3)
    public void testDeleteAddress() {
        addressPage.deleteFirstAddress();
        Assert.assertTrue(addressPage.isAddressDeleted(), "Address was not deleted successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}