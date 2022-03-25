package tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException
    {
        String host = "localhost";
        //DesiredCapabilities dc = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
        {
            options = new ChromeOptions();
            //dc = DesiredCapabilities.firefox();
        }
       /*else
        {
            dc = new ChromeOptions();
            System.out.println("Using Chrome"+dc);
        }*/

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        //String testName = ctx.getCurrentXmlTest().getName();
        String completeUrl = "http://" + host + ":4444/wd/hub";
        System.out.println("completeUrl is"+completeUrl);
        this.driver = new RemoteWebDriver(new URL(completeUrl), options);


    }

    @AfterTest
    public void quitbrowser() {
        this.driver.quit();
    }
}
