import io.qameta.allure.Feature;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchResultPage;
import static org.testng.Assert.*;
@Feature("Add Product Feature")
public class AddProductsToCartTests extends BaseTests{
    @Test (description = "Verify add products to cart with valid data")
    public void verifyAddProductsToCartWithValidData()
    {
        SearchResultPage searchResultPage = homePage.enterProductNameToSearchField("Proteus Fitness Jackshirt"+ Keys.ENTER);
        ProductDetailsPage productDetailsPage = searchResultPage.DisplayAllDetailsOfProduct();
        productDetailsPage.selectSpecificColor();
        productDetailsPage.selectSpecificSize();
        productDetailsPage.enterQuantityOfItem("5");
        productDetailsPage.clickOnAddToCart();
        String massageSuccess = productDetailsPage.getMassageSuccess();
        assertTrue(massageSuccess.contains("You added Proteus Fitness Jackshirt to your"),"Incorrect process for add product to cart");
    }
    @Test (description = "Verify Error Massage When Click On Add To Cart With out Determine Size")
    public void VerifyErrorMassageWhenClickOnAddToCartWithoutDetermineSize()
    {
        SearchResultPage searchResultPage = homePage.enterProductNameToSearchField("Proteus Fitness Jackshirt"+ Keys.ENTER);
        ProductDetailsPage productDetailsPage = searchResultPage.DisplayAllDetailsOfProduct();
        productDetailsPage.selectSpecificColor();
        productDetailsPage.enterQuantityOfItem("5");
        productDetailsPage.clickOnAddToCart();
        String sizeErrorMassage = productDetailsPage.getSizeErrorMassage();
        assertTrue(sizeErrorMassage.contains("This is a required field."),"Incorrect process for add product to cart");
    }
    @Test (description = "Verify Error Massage When Click On Add To Cart With out Determine Color")
    public void VerifyErrorMassageWhenClickOnAddToCartWithoutDetermineColor()
    {
        SearchResultPage searchResultPage = homePage.enterProductNameToSearchField("Proteus Fitness Jackshirt"+ Keys.ENTER);
        ProductDetailsPage productDetailsPage = searchResultPage.DisplayAllDetailsOfProduct();
        productDetailsPage.selectSpecificSize();
        productDetailsPage.enterQuantityOfItem("5");
        productDetailsPage.clickOnAddToCart();
        String colorErrorMassage = productDetailsPage.getColorErrorMassage();
        assertTrue(colorErrorMassage.contains("This is a required field."),"Incorrect process for add product to cart");
    }
}
