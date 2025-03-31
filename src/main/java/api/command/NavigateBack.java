package api.command;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NavigateBack extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        navigateBack();
        tearDown(driver);
    }
    private static void navigateBack() throws InterruptedException{
        driver.navigate().to("https://demoqa.com/text-box");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
    }
    private static void tearDown(WebDriver driver) { driver.close(); }
}
