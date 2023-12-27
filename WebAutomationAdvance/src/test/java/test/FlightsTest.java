package test;

import Page.FlightsPage;
import Page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTest extends BaseWebTest{
    @Test
    public void ExtractValue(){
        HomePage homePage = new HomePage(driver, explicitWait);
        FlightsPage flightsPage = new FlightsPage(driver,explicitWait);

        homePage.Home();
        flightsPage.Flight();
        String txtActualFlightPage = flightsPage.getTextActualFlightPage().replaceAll("\\n", " ");
        String txtExpectedFlightPage = "₹ 7,291 per adult";
        System.out.println("Top price from Make My Trip = " + flightsPage.getTextActualFlightPage().replaceAll("\\n", ""));
        Assert.assertEquals(txtActualFlightPage, txtExpectedFlightPage);
    }
}
