package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MyAccountPage{
    private WebDriver driver;
    private final By registrationMassageSuccessLocator = By.cssSelector("[data-ui-id=\"message-success\"]");
    private final By loginMassageSuccessLocator = By.className("base");
    MyAccountPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public boolean checkRegistrationMassageSuccess()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationMassageSuccessLocator));
        return driver.findElement(registrationMassageSuccessLocator).isDisplayed();
    }
    public boolean checkLoginMassageSuccess()
    {
        return driver.findElement(loginMassageSuccessLocator).isDisplayed();
    }
}
