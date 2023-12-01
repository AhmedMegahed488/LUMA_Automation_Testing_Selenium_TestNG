import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import pages.ShippingAddressPage;

import static org.testng.Assert.assertEquals;
@Feature("Cart Feature")
public class CartTests extends BaseTests{
    @Test (description = "Check the cart if it can work correctly")
    public void checkTheCartIfItCanWorkCorrectly()
    {
        SearchResultPage searchResultPage = homePage.enterProductNameToSearchField("Proteus Fitness Jackshirt" + Keys.ENTER);
        ProductDetailsPage productDetailsPage = searchResultPage.DisplayAllDetailsOfProduct();
        productDetailsPage.selectSpecificColor();
        productDetailsPage.selectSpecificSize();
        productDetailsPage.enterQuantityOfItem(Keys.DELETE+"5");
        productDetailsPage.clickOnAddToCart();
        productDetailsPage.goToCart();
        ShippingAddressPage shippingAddressPage = productDetailsPage.clickOnProceedToCheckoutButton();
        assertEquals(shippingAddressPage.getItemCount(),"5","Number of item is Incorrect");
    }
}
