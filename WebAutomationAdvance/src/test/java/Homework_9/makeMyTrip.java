package Homework_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class makeMyTrip {
    WebDriver driver;


    public void tugasMakeMyTrip(){
        WebDriverManager.edgedriver();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[.='Search']")));
        driver.findElement(By.xpath("//a[.='Search']")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='commonOverlay ']")));
        driver.findElement(By.xpath("//span[@class='bgProperties  overlayCrossIcon icon20']")).click();
        String txtActualMakeMyTrip = driver.findElement(By.xpath("//div[@class='clusterContent']/div[1]/div[1]//div[@class='blackText fontSize18 blackFont white-space-no-wrap clusterViewPrice']")).getText();
        Assert.assertTrue(txtActualMakeMyTrip.contains("₹ 6,977 \n per Adult"));
    }
}
