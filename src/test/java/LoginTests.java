import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertTrue;
@Feature("Login Feature")
public class LoginTests extends BaseTests{
    @Test (description = "Verify login when enter valid data")
    public void verifyOfLoginByValidData()
    {

        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.setEmail("ahmedmegahed488@gmail.com");
        loginPage.setPassword("Aa1@12345");
        MyAccountPage myAccountPage = loginPage.clickOnSubmitButton();
        assertTrue(myAccountPage.checkLoginMassageSuccess(),"incorrect Login");
    }
    @Test (description = "Verify login when enter empty email")
    public void VerifyLoginWhenEnterEmptyEmail()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.setPassword("Aa1@12345");
        MyAccountPage myAccountPage = loginPage.clickOnSubmitButton();
        String emailErrorMassage =loginPage.getEmailErrorMassage();
        assertTrue(emailErrorMassage.contains("This is a required field."),"Login Feature is not work correctly");
    }
    @Test (description = "Verify login when enter empty password")
    public void VerifyLoginWhenEnterEmptyPassword()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.setEmail("ahmedmegahed488@gmail.com");
        MyAccountPage myAccountPage = loginPage.clickOnSubmitButton();
        String passwordErrorMassage =loginPage.getPasswordErrorMassage();
        assertTrue(passwordErrorMassage.contains("This is a required field."),"Login Feature is not work correctly");
    }
    @Test (description = "Verify login when enter invalid email")
    public void VerifyLoginWhenEnterInvalidEmail()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.setEmail("ahmedmegahed4887766@gmail.com");
        loginPage.setPassword("Aa1@12345");
        MyAccountPage myAccountPage = loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isErrorMassageDisplayed(),"Login Feature is not work correctly");
    }
    @Test (description = "Verify login when enter invalid password")
    public void VerifyLoginWhenEnterInvalidPassword()
    {
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.setEmail("ahmedmegahed4887766@gmail.com");
        loginPage.setPassword("123455555");
        MyAccountPage myAccountPage = loginPage.clickOnSubmitButton();
        assertTrue(loginPage.isErrorMassageDisplayed(),"Login Feature is not work correctly");
    }
}
