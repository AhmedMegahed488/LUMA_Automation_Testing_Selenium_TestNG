package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAddressPage {
    private WebDriver driver;
    private final By itemCounterLocator = By.xpath("//span[@data-bind='text: getCartSummaryItemsCount()']");
    //-----------------------------------------------------------------------------
    private final By firstnameFieldLocator = By.name("firstname");
    private final By lastnameFieldLocator = By.name("lastname");
    private final By companyNameFieldLocator = By.name("company");
    private final By firstFieldForStreetAddressLocator = By.name("street[0]");
    private final By secondFieldForStreetAddressLocator = By.name("street[1]");
    private final By thirdFieldForStreetAddressLocator = By.name("street[2]");
    private final By cityFieldLocator = By.name("city");
    private final By countryFieldLocator = By.name("country_id");
    private final By stateOrRegionFieldLocator = By.name("region_id");
    private final By postalCodeFieldLocator = By.name("postcode");
    private final By phoneNumberFieldLocator = By.name("telephone");
    private final By shippingMethodsOne = By.xpath("//input[@value = 'tablerate_bestway']");
    private final By emailFieldLocator= By.id("customer-email");
    private final By nextButtonLocator = By.xpath("//*[@data-role= 'opc-continue']");
    private final By loaderImageLocator =By.className("loader");
    ShippingAddressPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String getItemCount()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemCounterLocator));
        return driver.findElement(itemCounterLocator).getText();
    }
    public void setEmail(String email)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderImageLocator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLocator));
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void setFirstname(String firstname)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstnameFieldLocator));
        driver.findElement(firstnameFieldLocator).sendKeys(firstname);
    }
    public void setLastname(String lastname)
    {
        driver.findElement(lastnameFieldLocator).sendKeys(lastname);
    }
    public void setCompanyName(String companyName)
    {
        driver.findElement(companyNameFieldLocator).sendKeys(companyName);
    }
    public void setFirstStreetAddress(String firstStreetAddress)
    {
        driver.findElement(firstFieldForStreetAddressLocator).sendKeys(firstStreetAddress);
    }
    public void setSecondStreetAddress(String secondStreetAddress)
    {
        driver.findElement(secondFieldForStreetAddressLocator).sendKeys(secondStreetAddress);
    }
    public void setThirdStreetAddress(String thirdStreetAddress)
    {
        driver.findElement(thirdFieldForStreetAddressLocator).sendKeys(thirdStreetAddress);
    }
    public void setCity(String city)
    {
        driver.findElement(cityFieldLocator).sendKeys(city);
    }
    public void setPostalCode(String postalCode)
    {
        driver.findElement(postalCodeFieldLocator).sendKeys(postalCode);
    }
    public void setPhoneNumber(String phoneNumber)
    {
        driver.findElement(phoneNumberFieldLocator).sendKeys(phoneNumber);
    }
    private Select findCountryField()
    {
        return new Select(driver.findElement(countryFieldLocator));
    }
    private Select findStateOrRegionField()
    {
        return new Select(driver.findElement(stateOrRegionFieldLocator));
    }
    public void selectOptionOfCountryField(String OptionText)
    {
        findCountryField().selectByVisibleText(OptionText);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodsOne));
    }
    public void selectOptionOfStateOrRegionField(String OptionText)
    {
        findStateOrRegionField().selectByVisibleText(OptionText);
    }
    public void clickOnShippingMethodsOne()
    {
        driver.findElement(shippingMethodsOne).click();
    }
    public ReviewAndPaymentsPage clickOnNextButton()
    {
        driver.findElement(nextButtonLocator).click();
        return new ReviewAndPaymentsPage(driver);
    }
}
