import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.ReviewAndPaymentsPage;
import pages.SearchResultPage;
import pages.ShippingAddressPage;

import static org.testng.Assert.*;
@Feature("Payment Feature")
public class AddressAndPaymentTests extends BaseTests{
    @Test (description = "Verify address and payment if it can work correctly with valid data")
    public void verifyAddressAndPaymentIfItCanWorkCorrectly()
    {
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
        shippingAddressPage.setEmail("ahmed555@gmail.com");
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
    }
}
