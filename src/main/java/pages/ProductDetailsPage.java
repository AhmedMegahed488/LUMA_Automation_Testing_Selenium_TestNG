package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    private WebDriver driver;
    private final By sizeSelectLocator = By.id("option-label-size-143-item-167");
    private final By colorSelectLocator = By.id("option-label-color-93-item-50");
    private final By quantityFieldLocator = By.id("qty");
    private final By addToCartButtonLocator = By.id("product-addtocart-button");
    private final By checkMassageLocator = By.xpath("//div[contains(@class , 'message-success')]");
    private final By massageSuccessLocator = By.tagName("div");
    private final By cartIconLocator = By.xpath("//a[@href='https://magento.softwaretestingboard.com/checkout/cart/']");
    private final By proceedToCheckoutButtonLocator = By.id("top-cart-btn-checkout");
    private final By productLocator = By.className("minicart-price");
    private final By productNameLocator = By.className("base");
    private final By quantityOfProductLocator = By.className("count");
    private final By colorErrorMassageLocator = By.id("super_attribute[93]-error");
    private final By sizeErrorMassageLocator = By.id("super_attribute[143]-error");
    ProductDetailsPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void selectSpecificSize()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeSelectLocator));
        driver.findElement(sizeSelectLocator).click();
    }
    public void selectSpecificColor()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorSelectLocator));
        driver.findElement(colorSelectLocator).click();
    }
    public void enterQuantityOfItem(String qty)
    {
        driver.findElement(quantityFieldLocator).sendKeys(qty);
    }
    public String getColorErrorMassage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorErrorMassageLocator));
        return driver.findElement(colorErrorMassageLocator).getText();
    }
    public String getSizeErrorMassage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeErrorMassageLocator));
        return driver.findElement(sizeErrorMassageLocator).getText();
    }
    public void clickOnAddToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButtonLocator));
        driver.findElement(addToCartButtonLocator).click();
    }
    public String getMassageSuccess()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkMassageLocator));
        WebElement checkElement = driver.findElement(checkMassageLocator);
        return checkElement.findElement(massageSuccessLocator).getText();
    }
    public void goToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkMassageLocator));
        driver.findElement(cartIconLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
    }
    public String getProductName()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator));
        return driver.findElement(productNameLocator).getText();
    }
    public String getQuantityOfProduct()
    {
        return driver.findElement(quantityOfProductLocator).getText();
    }
    public ShippingAddressPage clickOnProceedToCheckoutButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
        driver.findElement(proceedToCheckoutButtonLocator).click();
        return new ShippingAddressPage(driver);
    }
}
