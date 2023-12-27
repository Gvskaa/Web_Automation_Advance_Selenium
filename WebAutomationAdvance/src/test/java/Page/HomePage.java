package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait){
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }

    @FindBy(xpath = "//a[.='Search']")
    WebElement btnSearch;

    public void Home(){
        clickAndWait(btnSearch);
    }
}
