package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewAndPaymentsPage {
    private WebDriver driver;
    private final By paymentTitleLocator = By.className("payment-group");
    private final By productNameLocator = By.className("product-item-name");
    private final By quantityDetailsLocator = By.className("details-qty");
    private final By quantityOfProductLocator = By.className("value");
    private final By priceDetailsLocator = By.className("cart-price");
    private final By priceLocator = By.className("price");
    private final By submitLocator = By.xpath("//*[contains(text(),'Place Order')]");
    private final By massageSuccessPayment = By.className("base");
    private final By logoIconLocator= By.className("logo");

    ReviewAndPaymentsPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String getProductName()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(priceLocator));
        return driver.findElement(productNameLocator).getText();
    }
    public String getQuantityOfProduct()
    {
        WebElement element=driver.findElement(quantityDetailsLocator);
        return element.findElement(quantityOfProductLocator).getText();
    }
    public String getPrice()
    {
        WebElement element=driver.findElement(priceDetailsLocator);
        return element.findElement(priceLocator).getText();
    }
    public void clickOnPlaceOrderButton()
    {
        driver.findElement(submitLocator).click();
    }
    public void clickOnContinueShoppingButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(massageSuccessPayment));
        driver.findElement(logoIconLocator).click();
    }
}