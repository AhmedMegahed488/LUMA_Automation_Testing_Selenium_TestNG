package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("pass");
    private final By submitButtonLocator = By.id("send2");
    private final By emailErrorMassageLocator = By.id("email-error");
    private final By passwordErrorMassageLocator = By.id("pass-error");
    private final By errorMassageForLoginFail = By.xpath("//*[@data-ui-id='message-error']");
    LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setEmail(String email)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void setPassword(String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public String getEmailErrorMassage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMassageLocator));
        return driver.findElement(emailErrorMassageLocator).getText();
    }
    public String getPasswordErrorMassage()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordErrorMassageLocator));
        return driver.findElement(passwordErrorMassageLocator).getText();
    }
    public boolean isErrorMassageDisplayed()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMassageForLoginFail));
        return driver.findElement(errorMassageForLoginFail).isDisplayed();
    }
    public MyAccountPage clickOnSubmitButton()
    {
        driver.findElement(submitButtonLocator).click();
        return new MyAccountPage(driver);
    }
}
