import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import pages.RegisterPage;

import static org.testng.Assert.*;
@Feature("Registration Feature")
public class RegistrationTests extends BaseTests{
    @Test (description = "Verify register when enter valid data")
    public void verifyOfRegistrationByValidData()
    {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa1@12345");
        registerPage.setPasswordConfirmation("Aa1@12345");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        assertTrue(myAccountPage.checkRegistrationMassageSuccess(),"incorrect Registration");
    }
    @Test (description = "Verify register when enter empty first name")
    public void VerifyRegisterWhenEnterEmptyFirstname()
    {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa1@12345");
        registerPage.setPasswordConfirmation("Aa1@12345");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String firstnameErrorMassage = registerPage.getFirstnameErrorMassage();
        assertTrue(firstnameErrorMassage.contains("This is a required field."),"Login Feature is not work correctly");
    }
    @Test (description = "Verify register when enter invalid email (without @domain)")
    public void VerifyRegisterWhenEnterInvalidEmail()
    {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail("ffxg10");
        registerPage.setPassword("Aa1@12345");
        registerPage.setPasswordConfirmation("Aa1@12345");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String emailErrorMassage = registerPage.getEmailErrorMassage();
        assertTrue(emailErrorMassage.contains("Please enter a valid email address (Ex: johndoe@domain.com)."),"Login Feature is not work correctly");
    }
    @Test (description = "Verify register when enter invalid Password (without lower case Characters & upper case Characters) with length equal or greater than 8 symbols")
    public void VerifyRegisterWhenEnterInvalidPasswordWithoutLowerCaseCharactersAndUpperCaseCharacters()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("@1234567");
        registerPage.setPasswordConfirmation("@1234567");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String passwordErrorMassage = registerPage.getPasswordErrorMassage();
        assertTrue(passwordErrorMassage.contains("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."),"Register Feature is not work correctly");
    }
    @Test (description = "Verify register when enter invalid Password (without lower case Characters & Special Characters) with length equal or greater than 8 symbols")
    public void VerifyRegisterWhenEnterInvalidPasswordWithoutLowerCaseCharactersAndSpecialCharacters()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("AA1234567");
        registerPage.setPasswordConfirmation("AA1234567");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String passwordErrorMassage = registerPage.getPasswordErrorMassage();
        assertTrue(passwordErrorMassage.contains("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."),"Register Feature is not work correctly");
    }
    @Test (description = "Verify register when enter invalid Password (without Special Characters & upper case Characters) with length equal or greater than 8 symbols")
    public void VerifyRegisterWhenEnterInvalidPasswordWithoutSpecialCharactersAndUpperCaseCharacters()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("aa1234567");
        registerPage.setPasswordConfirmation("aa1234567");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String passwordErrorMassage = registerPage.getPasswordErrorMassage();
        assertTrue(passwordErrorMassage.contains("Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters."),"Register Feature is not work correctly");
    }
    @Test (description = "Verify register when enter valid Password with length equal 8 symbols")
    public void VerifyRegisterWhenEnterValidPasswordWithLengthEqualEightSymbols()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa@12345");
        registerPage.setPasswordConfirmation("Aa@12345");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        assertTrue(myAccountPage.checkRegistrationMassageSuccess(),"incorrect Registration");
    }
    @Test (description = "Verify register when enter valid Password with length greater than 8 symbols")
    public void VerifyRegisterWhenEnterValidPasswordWithLengthGreaterThanEightSymbols()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa@12345555");
        registerPage.setPasswordConfirmation("Aa@12345555");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        assertTrue(myAccountPage.checkRegistrationMassageSuccess(),"incorrect Registration");
    }
    @Test (description = "Verify register when enter valid Password with length less than 8 symbols")
    public void VerifyRegisterWhenEnterValidPasswordWithLengthLessThanEightSymbols()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa@123");
        registerPage.setPasswordConfirmation("Aa@123");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String passwordErrorMassage = registerPage.getPasswordErrorMassage();
        assertTrue(passwordErrorMassage.contains("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."),"Register Feature is not work correctly");
    }
    @Test (description = "Verify register when enter invalid Confirm Password")
    public void VerifyRegisterWhenEnterInvalidConfirmPassword()
    {
        String firstname = new Faker().name().firstName();
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa@12345");
        registerPage.setPasswordConfirmation("Aa@");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        String confirmationPasswordErrorMassage = registerPage.getConfirmationPasswordErrorMassage();
        assertTrue(confirmationPasswordErrorMassage.contains("Please enter the same value again."),"Register Feature is not work correctly");
    }
}
