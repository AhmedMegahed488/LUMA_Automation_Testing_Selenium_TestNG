import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.*;

import static org.testng.Assert.assertTrue;
@Feature("End2End Scenario")
public class EndToEndTests extends BaseTests {
    @Test (description = "Full End2End Scenario")
    public void verifyOfEndTwoEndScenario()
    {
        RegisterPage registerPage = homePage.clickOnRegisterLink();
        registerPage.setFirstname(new Faker().name().firstName());
        registerPage.setLastname(new Faker().name().lastName());
        registerPage.setEmail(new Faker().internet().emailAddress());
        registerPage.setPassword("Aa1@12345");
        registerPage.setPasswordConfirmation("Aa1@12345");
        MyAccountPage myAccountPage = registerPage.clickOnSubmitButton();
        assertTrue(myAccountPage.checkRegistrationMassageSuccess(),"incorrect Registration");
        SearchResultPage searchResultPage = homePage.enterProductNameToSearchField("Proteus Fitness Jackshirt"+ Keys.ENTER);
        ProductDetailsPage productDetailsPage = searchResultPage.DisplayAllDetailsOfProduct();
        productDetailsPage.selectSpecificColor();
        productDetailsPage.selectSpecificSize();
        productDetailsPage.enterQuantityOfItem(Keys.DELETE+"5");
        productDetailsPage.clickOnAddToCart();
        String productName1 = productDetailsPage.getProductName();
        productDetailsPage.goToCart();
        String quantityOfProduct1 =productDetailsPage.getQuantityOfProduct();
        ShippingAddressPage shippingAddressPage = productDetailsPage.clickOnProceedToCheckoutButton();
        shippingAddressPage.setFirstname("ahmed");
        shippingAddressPage.setLastname("megahed");
        shippingAddressPage.setCompanyName("Dell");
        shippingAddressPage.setFirstStreetAddress("the number of the house is 135");
        shippingAddressPage.setSecondStreetAddress("13 Area");
        shippingAddressPage.setThirdStreetAddress("gamal abdelnasser street");
        shippingAddressPage.setCity("Sadat");
        shippingAddressPage.selectOptionOfCountryField("United States");
        shippingAddressPage.selectOptionOfStateOrRegionField("Georgia");
        shippingAddressPage.setPostalCode("12345");
        shippingAddressPage.setPhoneNumber("01060948151");
        shippingAddressPage.clickOnShippingMethodsOne();
        ReviewAndPaymentsPage reviewAndPaymentsPage = shippingAddressPage.clickOnNextButton();
        String productName2 = reviewAndPaymentsPage.getProductName();
        String quantityOfProduct2 = reviewAndPaymentsPage.getQuantityOfProduct();
    }
}
