package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private final By firstnameLocator = By.id("firstname");
    private final By lastnameLocator = By.id("lastname");
    private final By emailAddressLocator = By.id("email_address");
    private final By passwordLocator = By.id("password");
    private final By passwordConfirmationLocator = By.name("password_confirmation");
    private final By submitButtonLocators = By.xpath("//*[contains(@class,'submit')]");
    private final By firstNameErrorMassageLocator = By.id("firstname-error");
    private final By emailErrorMassageLocator = By.id("email_address-error");
    private final By passwordErrorMassageLocator = By.id("password-error");
    private final By confirmationPasswordErrorMassageLocator = By.id("password-confirmation-error");
    RegisterPage(WebDriver driver){
        this.driver=driver;
    }
    public void setFirstname(String firstname)
    {
        driver.findElement(firstnameLocator).sendKeys(firstname);
    }
    public void setLastname(String lastname)
    {
        driver.findElement(lastnameLocator).sendKeys(lastname);
    }
    public void setEmail(String email)
    {
        driver.findElement(emailAddressLocator).sendKeys(email);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void setPasswordConfirmation(String passwordConfirmation)
    {
        driver.findElement(passwordConfirmationLocator).sendKeys(passwordConfirmation);
    }
    public String getFirstnameErrorMassage()
    {
        return driver.findElement(firstNameErrorMassageLocator).getText();
    }
    public String getEmailErrorMassage()
    {
        return driver.findElement(emailErrorMassageLocator).getText();
    }
    public String getPasswordErrorMassage()
    {
        return driver.findElement(passwordErrorMassageLocator).getText();
    }
    public String getConfirmationPasswordErrorMassage()
    {
        return driver.findElement(confirmationPasswordErrorMassageLocator).getText();
    }
    public MyAccountPage clickOnSubmitButton()
    {
        driver.findElement(submitButtonLocators).click();
        return new MyAccountPage(driver);
    }
}
