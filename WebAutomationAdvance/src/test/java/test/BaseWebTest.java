package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseWebTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public  ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments();
        driver.set(new EdgeDriver(options));
        driver.get().manage().window().maximize();
        driver.get().get("https://www.makemytrip.com/");
        explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));

    }

    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
