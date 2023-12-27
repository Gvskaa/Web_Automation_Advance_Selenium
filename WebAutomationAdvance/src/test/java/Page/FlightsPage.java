package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightsPage extends BasePage{
    public FlightsPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait){
        super(driver, explicitWait);
        PageFactory.initElements(driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='commonOverlay ']")
    WebElement popUp;

    @FindBy(xpath = "//span[@class='bgProperties  overlayCrossIcon icon20']")
    WebElement btnClose;

    @FindBy(xpath = "//div[@class='clusterContent']/div[1]/div[1]//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']")
    WebElement txtActualFlightPage;

    public void Flight(){
        wait(popUp);
        clickAndWait(btnClose);
    }

    public String getTextActualFlightPage(){
        return getText(txtActualFlightPage);
    }
}
