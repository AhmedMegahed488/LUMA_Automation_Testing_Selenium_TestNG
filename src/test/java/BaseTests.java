import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
    }
   @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
