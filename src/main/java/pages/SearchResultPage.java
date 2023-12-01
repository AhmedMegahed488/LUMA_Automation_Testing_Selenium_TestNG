package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
    private WebDriver driver;
    private final By productItemOne=By.xpath("//a[@href=\"https://magento.softwaretestingboard.com/proteus-fitness-jackshirt.html\"]");
    SearchResultPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public ProductDetailsPage DisplayAllDetailsOfProduct()
    {
        driver.findElement(productItemOne).click();
        return new ProductDetailsPage(driver);
    }

}
