package api.command;

import common.CommonConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NavigateTo extends CommonConfig {
    static WebDriver driver;
    public static void main(String args[]) throws IOException,InterruptedException {
        System.setProperty("webdriver.chrome.driver", chromePath());
        driver = new ChromeDriver();
        driver.get("https://skillupautomation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        navigateTo();
        tearDown(driver);
    }
    private static void navigateTo() {
        driver.navigate().to("https://demoqa.com/text-box");
    }
    private static void tearDown(WebDriver driver) { driver.close();}
}
