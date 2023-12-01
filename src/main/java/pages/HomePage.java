package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private final By registerLocator = By.linkText("Create an Account");
    private final By loginLocator = By.linkText("Sign In");
    private final By searchField = By.id("search");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public RegisterPage clickOnRegisterLink()
    {
        driver.findElement(registerLocator).click();
        return new RegisterPage(driver);
    }
    public LoginPage clickOnLoginLink()
    {
        driver.findElement(loginLocator).click();
        return new LoginPage(driver);
    }
    public SearchResultPage enterProductNameToSearchField(String productName)
    {
        driver.findElement(searchField).sendKeys(productName);
        return new SearchResultPage(driver);
    }

}
